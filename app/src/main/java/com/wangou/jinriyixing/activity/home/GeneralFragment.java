package com.wangou.jinriyixing.activity.home;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tong.library.base.BaseFragment;
import com.tong.library.bean.NewsContentBean;
import com.tong.library.bean.NewsTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.GeneralAdpter;
import com.wangou.jinriyixing.utils.GlideImageLoader;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class GeneralFragment extends BaseFragment {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.srfresh)
    SmartRefreshLayout srfresh;

    private GeneralAdpter generalAdpter;
    private List<NewsContentBean.DataBean.NewslistBean> dataList = new ArrayList<>();
    private int position;
    private int mPage = 0;
    private int mPageCount = 0;

    @SuppressLint("ValidFragment")
    public GeneralFragment(int position) {
        this.position = position;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_general;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initBanner();

        initNewsContent(mPage, true);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        generalAdpter = new GeneralAdpter(dataList);
        rlv.setAdapter(generalAdpter);
        srfresh.setRefreshHeader(new BezierRadarHeader(getActivity()).setEnableHorizontalDrag(true));
        srfresh.setRefreshFooter(new BallPulseFooter(getActivity()).setSpinnerStyle(SpinnerStyle.Scale));
        srfresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (mPage < mPageCount - 1) {
                    mPage++;
                } else {
                    mPage = 0;
                }
                initNewsContent(mPage, true);
                refreshLayout.finishRefresh(1200);
            }
        });
        srfresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (mPage < mPageCount - 1) {
                    mPage++;
                } else {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    return;
                }
                initNewsContent(mPage, false);
                refreshLayout.finishLoadMore(1200);
            }
        });
    }

    @Override
    protected void initEvent() {
        generalAdpter.setmOnMyItemClick((view, pos) -> {
            Intent intent = new Intent(getActivity(), NewsActivity.class);
            intent.putExtra("nid",dataList.get(pos).getN_id()+"");
            startActivity(intent);
        });
    }

    private void initBanner() {
        List<String> imgList = new ArrayList<>();
        imgList.add("http://pic35.photophoto.cn/20150519/0034034853356364_b.jpg");
        imgList.add("http://pic41.nipic.com/20140514/18741514_143130429189_2.jpg");
        imgList.add("http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg");
        banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();
        banner.setVisibility(View.GONE);
    }

    private void initNewsContent(int page, boolean isClear) {
        NewsTitleBean.DataBean dataBean = ((HomFragment) getParentFragment()).getDataList().get(position);
        Map<String, String> map = new HashMap<>();
        map.put("mid", dataBean.getId() + "");
        map.put("limit", "");
        map.put("page", page + "");
        map.put("key", "");
        Api.getInstance()
                .getNewsContent(ParamUtils.getNormalHeaderMap(), map)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<NewsContentBean>() {
                    @Override
                    public void onSuccess(NewsContentBean bean) {
                        if (bean.getCode() == 0) {
                            List<NewsContentBean.DataBean.NewslistBean> data = bean.getData().getNewslist();
                            mPage = bean.getData().getPage();
                            mPageCount = bean.getData().getPagecount();
                            if (isClear) {
                                dataList.clear();
                            }
                            dataList.addAll(data);
                            generalAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

}

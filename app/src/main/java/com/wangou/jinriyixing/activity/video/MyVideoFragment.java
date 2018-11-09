package com.wangou.jinriyixing.activity.video;


import android.annotation.SuppressLint;
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
import com.tong.library.bean.VideoListBean;
import com.tong.library.bean.VideoTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.MyVideoAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class MyVideoFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.srfresh)
    SmartRefreshLayout srfresh;
    private int position;

    private List<VideoListBean.DataBean.ListBean> dataList = new ArrayList<>();
    private MyVideoAdpter myVideoAdpter;
    private int mPage = 0;
    private int mPageCount = 0;

    @SuppressLint("ValidFragment")
    public MyVideoFragment(int position) {
        this.position = position;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_my_video;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myVideoAdpter = new MyVideoAdpter(getActivity(), dataList);
        rlv.setAdapter(myVideoAdpter);
        initVideoList(mPage, true);
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
                initVideoList(mPage, true);
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
                initVideoList(mPage, false);
                refreshLayout.finishLoadMore(1200);
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    private void initVideoList(int page, boolean isClear) {
        VideoTitleBean.DataBean dataBean = ((VideoFragment) getParentFragment()).getDataList().get(position);
        Map<String, String> map = new HashMap<>();
        map.put("vmid", dataBean.getVmid() + "");
        map.put("limit", "");
        map.put("page", page + "");
        Api.getInstance()
                .getVideoList(ParamUtils.getNormalHeaderMap(), map)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<VideoListBean>() {
                    @Override
                    public void onSuccess(VideoListBean videoListBean) {
                        if (videoListBean.getCode() == 0) {
                            VideoListBean.DataBean data = videoListBean.getData();
                            mPageCount = data.getPagecount();
                            List<VideoListBean.DataBean.ListBean> list = data.getList();
                            if (isClear) {
                                dataList.clear();
                            }
                            dataList.addAll(list);
                            myVideoAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}

package com.wangou.jinriyixing.activity.collection;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.base.BaseFragment;
import com.tong.library.bean.BannerBean;
import com.tong.library.bean.CollectionListBean;
import com.tong.library.bean.CollectionTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ContentAdpter;
import com.wangou.jinriyixing.adpter.GuideAdpter;
import com.wangou.jinriyixing.base.RequestHelper;
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
public class HotFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rlv_guide)
    RecyclerView rlvGuide;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;
    private int pos;

    private List<CollectionListBean.DataBean.ListBean> dataList = new ArrayList<>();
    private ContentAdpter contentAdpter;

    @SuppressLint("ValidFragment")
    public HotFragment(int pos) {
        this.pos = pos;
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initGuide();
        RequestHelper.initBanner("14",banner);
        initContent();
    }

    @Override
    protected void initEvent() {

    }

    private void initGuide() {
        List<String> titleList = new ArrayList<>();
        titleList.add("话语");
        titleList.add("诗集");
        titleList.add("对联");
        titleList.add("作文");
        titleList.add("书法");
        titleList.add("更多");
        rlvGuide.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        GuideAdpter guideAdpter = new GuideAdpter(getActivity(), titleList);
        rlvGuide.setAdapter(guideAdpter);
    }

    private void initContent() {
        contentAdpter = new ContentAdpter(getActivity(), dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rlvContent.setLayoutManager(linearLayoutManager);
        rlvContent.setAdapter(contentAdpter);

        List<CollectionTitleBean.DataBean> data = ((CollectionFragment) getParentFragment()).getDataList();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("mid", data.get(pos).getVmid() + "");
        paramMap.put("type", "");
        paramMap.put("page", "");
        Api.getInstance()
                .getCollectionList(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CollectionListBean>() {
                    @Override
                    public void onSuccess(CollectionListBean collectionListBean) {
                        if (collectionListBean.getCode() == 0) {
                            CollectionListBean.DataBean info = collectionListBean.getData();
                            List<CollectionListBean.DataBean.ListBean> data = info.getList();
                            dataList.clear();
                            dataList.addAll(data);
                            contentAdpter.notifyDataSetChanged();
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
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }
}

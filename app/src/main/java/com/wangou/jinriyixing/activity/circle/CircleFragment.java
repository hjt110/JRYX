package com.wangou.jinriyixing.activity.circle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseFragment;
import com.tong.library.bean.BannerBean;
import com.tong.library.bean.CircleListBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.CircleAdpter;
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
public class CircleFragment extends BaseFragment {

    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_pen)
    ImageView imgPen;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.banner)
    Banner banner;

    private List<CircleListBean.DataBean.ListBean> dataList = new ArrayList<>();
    private CircleAdpter circleAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        RequestHelper.initBanner("15", banner);
        initContent();
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        circleAdpter = new CircleAdpter(getActivity(), dataList);
        rlv.setAdapter(circleAdpter);
    }

    @Override
    protected void initEvent() {

    }

    private void initContent() {
        Map<String, String> headerMap = ParamUtils.getNormalHeaderMap();
        headerMap.put("token", "");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("page", "");
        Api.getInstance()
                .getCircleList(headerMap, paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<CircleListBean>() {
                    @Override
                    public void onSuccess(CircleListBean circleListBean) {
                        if (circleListBean.getCode() == 0) {
                            CircleListBean.DataBean data = circleListBean.getData();
                            List<CircleListBean.DataBean.ListBean> list = data.getList();
                            dataList.clear();
                            dataList.addAll(list);
                            circleAdpter.notifyDataSetChanged();
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

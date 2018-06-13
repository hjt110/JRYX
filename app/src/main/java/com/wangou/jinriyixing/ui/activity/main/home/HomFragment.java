package com.wangou.jinriyixing.ui.activity.main.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tong.library.base.BaseMvpFragment;
import com.tong.library.view.CircleImageView;
import com.tong.library.view.PagerSlidingTabStrip;
import com.wangou.jinriyixing.R;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomFragment extends BaseMvpFragment<HomePresenter, HomeContract.View> implements HomeContract.View {


    @BindView(R.id.img_home_head)
    CircleImageView imgHomeHead;
    @BindView(R.id.img_home_logo)
    ImageView imgHomeLogo;
    @BindView(R.id.img_home_search)
    ImageView imgHomeSearch;
    @BindView(R.id.psts_home)
    PagerSlidingTabStrip pstsHome;
    @BindView(R.id.img_home_show)
    ImageView imgHomeShow;
    @BindView(R.id.banner_home)
    Banner bannerHome;
    @BindView(R.id.rlv_home)
    RecyclerView rlvHome;

    public HomFragment() {
        // Required empty public constructor
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hom;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rlvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected void initEvent() {

    }

}

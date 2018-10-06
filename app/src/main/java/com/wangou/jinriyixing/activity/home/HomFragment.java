package com.wangou.jinriyixing.activity.home;


import android.app.Application;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tong.library.base.BaseFragment;
import com.tong.library.bean.NewsTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.utils.JsonParse;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;
import com.wangou.jinriyixing.base.BaseApplication;
import com.wangou.jinriyixing.utils.DeviceUtils;
import com.wangou.jinriyixing.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomFragment extends BaseFragment {

    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.titleBar)
    LinearLayout titleBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdpter viewPagerAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hom;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initNews();
        viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(viewPagerAdpter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initEvent() {

    }

    private void initNews() {
        HashMap<String,String> headmap = new HashMap<>();
        headmap.put("deviceid", DeviceUtils.getUniqueId());
        headmap.put("time", System.currentTimeMillis()+"");
        Api.getInstance().getNewsTitle(headmap)
                .compose(RxSchedulers.io_main())
                .subscribe(bean -> {
                    List<NewsTitleBean.DataBean> data = bean.getData();
                    for (NewsTitleBean.DataBean dataBean: data){
                        titleList.add(dataBean.getMenu_name());
                        fragmentList.add(new GeneralFragment());
                    }
                    viewPagerAdpter.notifyDataSetChanged();
                });
    }

}

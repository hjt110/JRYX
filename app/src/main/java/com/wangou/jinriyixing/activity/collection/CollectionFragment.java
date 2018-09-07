package com.wangou.jinriyixing.activity.collection;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends BaseFragment {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_collection;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initViewPager();
    }

    @Override
    protected void initEvent() {

    }

    private void initViewPager() {
        List<String> titleList = new ArrayList<>();
        titleList.add("征集");
        titleList.add("热门");
        titleList.add("进行");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HotFragment());
        fragmentList.add(new HotFragment());
        fragmentList.add(new HotFragment());
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        vp.setAdapter(viewPagerAdpter);
        tablayout.setupWithViewPager(vp);
    }

}

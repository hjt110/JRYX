package com.wangou.jinriyixing.activity.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;

import java.util.ArrayList;
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

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hom;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        initListInfo();
        initNews();
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(viewPagerAdpter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    protected void initEvent() {

    }

    private void initNews() {

    }

    private void initListInfo() {
        titleList.add("推荐");
        titleList.add("综合");
        titleList.add("艺术");
        titleList.add("生活");
        fragmentList.add(new GeneralFragment());
        fragmentList.add(new GeneralFragment());
        fragmentList.add(new GeneralFragment());
        fragmentList.add(new GeneralFragment());
    }

}

package com.wangou.jinriyixing.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wangou.jinriyixing.activity.home.HomFragment;

import java.util.List;

public class MainAdpter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public MainAdpter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}

package com.wangou.jinriyixing.ui.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wangou.jinriyixing.ui.activity.main.home.HomFragment;

public class MainAdpter extends FragmentPagerAdapter {
    public MainAdpter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        fragment = new HomFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

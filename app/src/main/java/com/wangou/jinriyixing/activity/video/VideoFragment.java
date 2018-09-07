package com.wangou.jinriyixing.activity.video;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.activity.collection.HotFragment;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.img_camera)
    ImageView imgCamera;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initViewPager();
    }

    @Override
    protected void initEvent() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                JZVideoPlayer.releaseAllVideos();
            }
        });
    }

    private void initViewPager() {
        List<String> titleList = new ArrayList<>();
        titleList.add("推荐");
        titleList.add("美女");
        titleList.add("美食");
        titleList.add("户外");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyVideoFragment());
        fragmentList.add(new MyVideoFragment());
        fragmentList.add(new MyVideoFragment());
        fragmentList.add(new MyVideoFragment());
        ViewPagerAdpter viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        vp.setAdapter(viewPagerAdpter);
        tabLayout.setupWithViewPager(vp);
    }


}

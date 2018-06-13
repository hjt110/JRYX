package com.wangou.jinriyixing.ui.activity.main;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.ui.adpter.MainAdpter;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.img_main_release)
    ImageView imgMainRelease;
    @BindView(R.id.cl_main_release)
    ConstraintLayout clMainRelease;
    @BindView(R.id.img_main_home)
    ImageView imgMainHome;
    @BindView(R.id.tv_main_home)
    TextView tvMainHome;
    @BindView(R.id.cl_main_home)
    ConstraintLayout clMainHome;
    @BindView(R.id.img_main_collection)
    ImageView imgMainCollection;
    @BindView(R.id.tv_main_collection)
    TextView tvMainCollection;
    @BindView(R.id.cl_main_collection)
    ConstraintLayout clMainCollection;
    @BindView(R.id.img_main_circle)
    ImageView imgMainCircle;
    @BindView(R.id.tv_main_circle)
    TextView tvMainCircle;
    @BindView(R.id.cl_main_circle)
    ConstraintLayout clMainCircle;
    @BindView(R.id.img_main_video)
    ImageView imgMainVideo;
    @BindView(R.id.tv_main_video)
    TextView tvMainVideo;
    @BindView(R.id.cl_main_video)
    ConstraintLayout clMainVideo;
    @BindView(R.id.cl_main_bottom)
    ConstraintLayout clMainBottom;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        upIc(0);

        MainAdpter mainAdpter = new MainAdpter(getSupportFragmentManager());
        vpMain.setAdapter(mainAdpter);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                upIc(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initEvent() {
        clMainHome.setOnClickListener(this);
        clMainCollection.setOnClickListener(this);
        clMainRelease.setOnClickListener(this);
        clMainCircle.setOnClickListener(this);
        clMainVideo.setOnClickListener(this);
    }

    public void upIc(int pos) {
        imgMainHome.setImageResource(R.mipmap.ic_main_home);
        tvMainHome.setTextColor(getResources().getColor(R.color.grey_9));
        imgMainCollection.setImageResource(R.mipmap.ic_main_collection);
        tvMainCollection.setTextColor(getResources().getColor(R.color.grey_9));
        imgMainCircle.setImageResource(R.mipmap.ic_main_circle);
        tvMainCircle.setTextColor(getResources().getColor(R.color.grey_9));
        imgMainVideo.setImageResource(R.mipmap.ic_main_video);
        tvMainVideo.setTextColor(getResources().getColor(R.color.grey_9));
        switch (pos) {
            case 0:
                imgMainHome.setImageResource(R.mipmap.ic_main_home_red);
                tvMainHome.setTextColor(getResources().getColor(R.color.red));
                break;
            case 1:
                imgMainCollection.setImageResource(R.mipmap.ic_main_collection_red);
                tvMainCollection.setTextColor(getResources().getColor(R.color.red));
                break;
            case 2:
                imgMainCircle.setImageResource(R.mipmap.ic_main_circle_red);
                tvMainCircle.setTextColor(getResources().getColor(R.color.red));
                break;
            case 3:
                imgMainVideo.setImageResource(R.mipmap.ic_main_video_red);
                tvMainVideo.setTextColor(getResources().getColor(R.color.red));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cl_main_home:
                upIc(0);
                vpMain.setCurrentItem(0);
                break;
            case R.id.cl_main_collection:
                upIc(1);
                vpMain.setCurrentItem(1);
                break;
            case R.id.cl_main_release:
                break;
            case R.id.cl_main_circle:
                upIc(2);
                vpMain.setCurrentItem(2);
                break;
            case R.id.cl_main_video:
                upIc(3);
                vpMain.setCurrentItem(3);
                break;
        }
    }
}

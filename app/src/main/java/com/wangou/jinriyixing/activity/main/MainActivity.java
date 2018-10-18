package com.wangou.jinriyixing.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tong.library.base.BaseActivity;
import com.tong.library.utils.StatusBarCompat;
import com.tong.library.view.CircleImageView;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.activity.circle.CircleFragment;
import com.wangou.jinriyixing.activity.collection.CollectionFragment;
import com.wangou.jinriyixing.activity.home.HomFragment;
import com.wangou.jinriyixing.activity.login.LoginActivity;
import com.wangou.jinriyixing.activity.video.VideoFragment;
import com.wangou.jinriyixing.adpter.MainAdpter;
import com.wangou.jinriyixing.adpter.NavLeftAdpter;
import com.wangou.jinriyixing.utils.AesEncryptionUtil;
import com.wangou.jinriyixing.utils.DeviceUtils;
import com.wangou.jinriyixing.utils.LogUtils;
import com.wangou.jinriyixing.utils.RsaUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;

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
    @BindView(R.id.img_header)
    CircleImageView imgHeader;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_sign)
    TextView tvSign;
    @BindView(R.id.tv_dynamic)
    TextView tvDynamic;
    @BindView(R.id.tv_giveGood)
    TextView tvGiveGood;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.ll_state)
    LinearLayout llState;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.nav_left)
    FrameLayout navLeft;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.rl_setting)
    RelativeLayout rlSetting;
    @BindView(R.id.rl_email)
    RelativeLayout rlEmail;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initViewPager();
        initLeft();
    }

    @Override
    protected void initEvent() {
        clMainHome.setOnClickListener(this);
        clMainCollection.setOnClickListener(this);
        clMainRelease.setOnClickListener(this);
        clMainCircle.setOnClickListener(this);
        clMainVideo.setOnClickListener(this);

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
                JZVideoPlayer.releaseAllVideos();
            }
        });

//        test();
    }

    private void initViewPager() {
        upIc(0);

        fragmentList.add(new HomFragment());
        fragmentList.add(new CollectionFragment());
        fragmentList.add(new CircleFragment());
        fragmentList.add(new VideoFragment());
        MainAdpter mainAdpter = new MainAdpter(getSupportFragmentManager(), fragmentList);
        vpMain.setAdapter(mainAdpter);
        vpMain.setOffscreenPageLimit(3);
    }

    private void initLeft() {
        navLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        List<String> titleList = new ArrayList<>();
        titleList.add("我的圈子");
        titleList.add("我的收藏");
        titleList.add("编辑资料");
        titleList.add("我的名片");
        titleList.add("作品管理");
        titleList.add("消息通知");
        titleList.add("用户反馈");
        rlv.setLayoutManager(new LinearLayoutManager(this));
        NavLeftAdpter navLeftAdpter = new NavLeftAdpter(this, titleList);
        rlv.setAdapter(navLeftAdpter);
        imgHeader.setOnClickListener(v -> startActivity(new Intent(this, InfoSetActivity.class)));
        rlSetting.setOnClickListener(v -> startActivity(new Intent(this, SetActivity.class)));
    }

    private void test() {
        String uniqueId = DeviceUtils.getUniqueId(this);
        LogUtils.e("uniqueId", uniqueId);
        long l = System.currentTimeMillis() / 1000;
        String key = "aaaabbbbddddcccc";
        LogUtils.e("l", l + "");
        Map<String, String> map = new HashMap<>();
        map.put("time", l + "");
        map.put("key", key);
        String result = mapToJson(map);
        LogUtils.e("json", result);
        String rsaResult = RsaUtils.encryptByPublic(result);
        LogUtils.e("rsaResult", rsaResult);
        String replace = rsaResult.replaceAll("\\s*", "");
        LogUtils.e("rsaResult2", replace);

        Map<String, String> map1 = new HashMap<>();
        map1.put("time", l + "");
        map1.put("type", "login");
        map1.put("mobile", "18120845138");
        String s = mapToJson(map1);
        LogUtils.e("s", s);
        String encrypt = AesEncryptionUtil.encrypt(s, key, AesEncryptionUtil.IV);
        LogUtils.e("encrypt", encrypt);

    }

    /**
     * 将Map转化为Json字符串
     *
     * @param map
     * @return String
     */
    public static <T> String mapToJson(Map<String, T> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }

    public void upIc(int pos) {
        imgMainHome.setImageResource(R.mipmap.ic_main_home);
        tvMainHome.setTextColor(getResources().getColor(R.color.color_9));
        imgMainCollection.setImageResource(R.mipmap.ic_main_collection);
        tvMainCollection.setTextColor(getResources().getColor(R.color.color_9));
        imgMainCircle.setImageResource(R.mipmap.ic_main_circle);
        tvMainCircle.setTextColor(getResources().getColor(R.color.color_9));
        imgMainVideo.setImageResource(R.mipmap.ic_main_video);
        tvMainVideo.setTextColor(getResources().getColor(R.color.color_9));
        switch (pos) {
            case 0:
                setStatusBar(getResources().getColor(R.color.red_little));
                setStatusBarIconDark(false);
                imgMainHome.setImageResource(R.mipmap.ic_main_home_red);
                tvMainHome.setTextColor(getResources().getColor(R.color.red));
                break;
            case 1:
                setStatusBar(getResources().getColor(R.color.white));
                setStatusBarIconDark(true);
                imgMainCollection.setImageResource(R.mipmap.ic_main_collection_red);
                tvMainCollection.setTextColor(getResources().getColor(R.color.red));
                break;
            case 2:
                setStatusBar(getResources().getColor(R.color.white));
                setStatusBarIconDark(true);
                imgMainCircle.setImageResource(R.mipmap.ic_main_circle_red);
                tvMainCircle.setTextColor(getResources().getColor(R.color.red));
                break;
            case 3:
                setStatusBar(getResources().getColor(R.color.white));
                setStatusBarIconDark(true);
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
                startActivity(new Intent(getActivity(), LoginActivity.class));
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

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

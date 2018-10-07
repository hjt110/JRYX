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
import com.tong.library.bean.VideoTitleBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RxSchedulers;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.activity.collection.HotFragment;
import com.wangou.jinriyixing.adpter.ViewPagerAdpter;
import com.wangou.jinriyixing.utils.ParamUtils;

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

    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPagerAdpter viewPagerAdpter;
    private List<VideoTitleBean.DataBean> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initViewPager();
        initVideo();
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
        viewPagerAdpter = new ViewPagerAdpter(getChildFragmentManager(), titleList, fragmentList);
        vp.setAdapter(viewPagerAdpter);
        tabLayout.setupWithViewPager(vp);
    }

    private void initVideo() {
        Api.getInstance()
                .getVideoTitle(ParamUtils.getNormalHeaderMap())
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<VideoTitleBean>() {
                    @Override
                    public void onSuccess(VideoTitleBean videoTitleBean) {
                        if (videoTitleBean.getCode()==0){
                            List<VideoTitleBean.DataBean> data = videoTitleBean.getData();
                            setDataList(data);
                            for (int i = 0; i < data.size(); i++) {
                                titleList.add(data.get(i).getName());
                                fragmentList.add(new MyVideoFragment(i));
                            }
                            viewPagerAdpter.notifyDataSetChanged();
                        }
                    }
                });
    }

    public List<VideoTitleBean.DataBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<VideoTitleBean.DataBean> dataList) {
        this.dataList = dataList;
    }
}

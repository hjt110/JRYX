package com.wangou.jinriyixing.activity.collection;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.ContentAdpter;
import com.wangou.jinriyixing.adpter.GuideAdpter;
import com.wangou.jinriyixing.utils.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rlv_guide)
    RecyclerView rlvGuide;
    @BindView(R.id.rlv_content)
    RecyclerView rlvContent;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        List<String> imgList = new ArrayList<>();
        imgList.add("http://imgsrc.baidu.com/imgad/pic/item/b21bb051f8198618b4505a5040ed2e738ad4e6cb.jpg");
        imgList.add("http://pic1.win4000.com/wallpaper/d/58070b53cd218.jpg");
        imgList.add("http://pic1.16pic.com/00/11/69/16pic_1169706_b.jpg");
        banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();
        initGuide();
        initContent();
    }

    @Override
    protected void initEvent() {

    }

    private void initGuide() {
        List<String> titleList = new ArrayList<>();
        titleList.add("话语");
        titleList.add("诗集");
        titleList.add("对联");
        titleList.add("作文");
        titleList.add("书法");
        titleList.add("更多");
        rlvGuide.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        GuideAdpter guideAdpter = new GuideAdpter(getActivity(), titleList);
        rlvGuide.setAdapter(guideAdpter);
    }

    private void initContent() {
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titleList.add("行路难" + i);
        }
        ContentAdpter contentAdpter = new ContentAdpter(getActivity(), titleList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rlvContent.setLayoutManager(linearLayoutManager);
        rlvContent.setAdapter(contentAdpter);
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (banner != null) {
            banner.stopAutoPlay();
        }
    }
}

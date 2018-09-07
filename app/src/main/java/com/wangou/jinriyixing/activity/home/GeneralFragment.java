package com.wangou.jinriyixing.activity.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.GeneralAdpter;
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
public class GeneralFragment extends BaseFragment {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.banner)
    Banner banner;

    private GeneralAdpter generalAdpter;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_general;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        List<String> imgList = new ArrayList<>();
        imgList.add("http://pic35.photophoto.cn/20150519/0034034853356364_b.jpg");
        imgList.add("http://pic41.nipic.com/20140514/18741514_143130429189_2.jpg");
        imgList.add("http://imgsrc.baidu.com/imgad/pic/item/34fae6cd7b899e51fab3e9c048a7d933c8950d21.jpg");
        banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();

        rlv.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        generalAdpter = new GeneralAdpter();
        rlv.setAdapter(generalAdpter);

    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }
}

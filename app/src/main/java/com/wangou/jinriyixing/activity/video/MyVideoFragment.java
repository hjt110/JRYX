package com.wangou.jinriyixing.activity.video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.MyVideoAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyVideoFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_my_video;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titleList.add("test"+i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyVideoAdpter myVideoAdpter = new MyVideoAdpter(getActivity(), titleList);
        rlv.setAdapter(myVideoAdpter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

}

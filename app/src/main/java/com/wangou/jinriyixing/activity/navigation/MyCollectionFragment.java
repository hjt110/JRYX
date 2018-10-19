package com.wangou.jinriyixing.activity.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.MyCircleAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectionFragment extends BaseFragment {


    @BindView(R.id.rlv)
    RecyclerView rlv;
    private List<String> dataList= new ArrayList<>();

    public MyCollectionFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_my_collection;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        for (int i = 0; i < 5; i++) {
            dataList.add("test"+i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyCircleAdpter myCircleAdpter = new MyCircleAdpter(getActivity(), dataList);
        rlv.setAdapter(myCircleAdpter);

    }

    @Override
    protected void initEvent() {

    }

}

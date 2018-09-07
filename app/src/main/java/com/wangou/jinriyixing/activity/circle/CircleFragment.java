package com.wangou.jinriyixing.activity.circle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseFragment;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.CircleAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends BaseFragment {

    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_pen)
    ImageView imgPen;
    @BindView(R.id.rlv)
    RecyclerView rlv;

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_circle;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        List<String> titleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titleList.add("test" + i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        CircleAdpter circleAdpter = new CircleAdpter(getActivity(), titleList);
        rlv.setAdapter(circleAdpter);
    }

    @Override
    protected void initEvent() {

    }

}

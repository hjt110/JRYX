package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.PrivateLetterAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrivateLetterActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_private_letter;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("我的私信");
        for (int i = 0; i < 5; i++) {
            dataList.add("test"+i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(this));
        PrivateLetterAdpter privateLetterAdpter = new PrivateLetterAdpter(this, dataList);
        rlv.setAdapter(privateLetterAdpter);
    }

    @Override
    protected void initEvent() {
        imgBack.setOnClickListener(v -> finish());
    }

}

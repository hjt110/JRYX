package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.MessageAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rlv)
    RecyclerView rlv;

    private List<String> dataList = new ArrayList<>();


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_message;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("消息通知");
        for (int i = 0; i < 5; i++) {
            dataList.add("test"+i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(this));
        MessageAdpter messageAdpter = new MessageAdpter(this, dataList);
        rlv.setAdapter(messageAdpter);
    }

    @Override
    protected void initEvent() {
        imgBack.setOnClickListener(v -> finish());

    }

}

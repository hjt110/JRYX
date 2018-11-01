package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;
import com.wangou.jinriyixing.adpter.MyCircleAdpter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyCircleActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.rlv)
    RecyclerView rlv;

    private List<String> dataList = new ArrayList<>();

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_my_circle;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("我的圈子");
        imgRight.setImageResource(R.mipmap.community_publish);

        for (int i = 0; i < 5; i++) {
            dataList.add("test"+i);
        }
        rlv.setLayoutManager(new LinearLayoutManager(this));
        MyCircleAdpter myCircleAdpter = new MyCircleAdpter(this, dataList);
        rlv.setAdapter(myCircleAdpter);
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.img_back,R.id.img_right})
    public void myClick(View view){
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_right:
                break;
        }
    }

}

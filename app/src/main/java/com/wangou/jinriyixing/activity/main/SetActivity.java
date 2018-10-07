package com.wangou.jinriyixing.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_phoneNum)
    TextView tvPhoneNum;
    @BindView(R.id.rl_phone)
    RelativeLayout rlPhone;
    @BindView(R.id.rl_setPwd)
    RelativeLayout rlSetPwd;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.tv_exit)
    TextView tvExit;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_set;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tvTitle.setText("系统设置");
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.img_back, R.id.rl_phone, R.id.rl_setPwd, R.id.rl_about, R.id.tv_exit})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_phone:
                break;
            case R.id.rl_setPwd:
                break;
            case R.id.rl_about:
                break;
            case R.id.tv_exit:
                break;
            default:
                break;
        }

    }

}

package com.wangou.jinriyixing.activity.navigation;

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

public class InfoSetActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_head)
    ImageView imgHead;
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.tv_userName)
    TextView tvUserName;
    @BindView(R.id.rl_userName)
    RelativeLayout rlUserName;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.rl_sex)
    RelativeLayout rlSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.rl_birthday)
    RelativeLayout rlBirthday;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.rl_area)
    RelativeLayout rlArea;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_info_set;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("编辑资料");
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.img_back, R.id.rl_head, R.id.rl_userName, R.id.rl_about, R.id.rl_sex, R.id.rl_birthday, R.id.rl_area})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_head:
                break;
            case R.id.rl_userName:
                break;
            case R.id.rl_about:
                break;
            case R.id.rl_sex:
                break;
            case R.id.rl_birthday:
                break;
            case R.id.rl_area:
                break;
            default:
                break;
        }
    }

}

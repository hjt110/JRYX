package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserFeedbackActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edit_about)
    EditText editAbout;
    @BindView(R.id.rl_add)
    RelativeLayout rlAdd;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user_feedback;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("用戶反馈");

    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.img_back,R.id.rl_add})
    public void myClick(View view){
        switch (view.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.rl_add:
                break;
        }
    }

}

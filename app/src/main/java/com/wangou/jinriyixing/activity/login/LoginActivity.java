package com.wangou.jinriyixing.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void initEvent() {

    }

    public void finish(View view) {
        finish();
    }

    public void register(View view) {
        startActivity(new Intent(getActivity(), RegisterActivity.class));
    }
}

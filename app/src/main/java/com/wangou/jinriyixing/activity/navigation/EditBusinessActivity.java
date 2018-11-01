package com.wangou.jinriyixing.activity.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditBusinessActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.edit_person)
    EditText editPerson;
    @BindView(R.id.img_add)
    ImageView imgAdd;
    @BindView(R.id.img_delete)
    ImageView imgDelete;
    @BindView(R.id.edit_business)
    EditText editBusiness;
    @BindView(R.id.tv_logo)
    TextView tvLogo;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_edit_business;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setStatusBarColor(R.color.white);
        setStatusBarIcon(true);
        tvTitle.setText("编辑名片");

    }

    @Override
    protected void initEvent() {

    }

    @OnClick(R.id.img_back)
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }

}

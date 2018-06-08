package com.wangou.jinriyixing.ui.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;
import com.wangou.jinriyixing.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter,MainContract.View> implements MainContract.View {

    @BindView(R.id.tv_main)
    TextView tvMain;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.setText(getP().add(tvMain.getText().toString()));
            }
        });
    }


}

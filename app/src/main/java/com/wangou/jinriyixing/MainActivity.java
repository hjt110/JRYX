package com.wangou.jinriyixing;

import android.os.Bundle;
import android.widget.TextView;

import com.tong.library.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_main)
    TextView tvMain;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tvMain.setText("hahahah");
    }

}

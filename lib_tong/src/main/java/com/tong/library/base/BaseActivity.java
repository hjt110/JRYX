package com.tong.library.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tong.library.mvp.BaseView;
import com.tong.library.utils.EventBusUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder mUnbinder;
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        activity = this;

        //two test
        init(savedInstanceState);
    }

    protected abstract int getLayoutResID();

    protected abstract void init(Bundle savedInstanceState);

    public Activity getActivity() {
        return activity;
    }

    protected boolean isUseEventBus(){
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isUseEventBus()){
            EventBusUtils.register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (isUseEventBus()){
            EventBusUtils.unregister(this);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}

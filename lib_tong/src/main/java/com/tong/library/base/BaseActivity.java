package com.tong.library.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tong.library.mvp.IBaseView;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    private Unbinder mUnbinder;
    private Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        activity = this;
        init(savedInstanceState);
        initEvent();
    }

    protected abstract int getLayoutResID();

    protected abstract void init(Bundle savedInstanceState);

    protected abstract void initEvent();

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
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (isUseEventBus()){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

}

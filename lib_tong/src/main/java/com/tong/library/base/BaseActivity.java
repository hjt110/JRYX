package com.tong.library.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tong.library.mvp.BasePresenter;
import com.tong.library.mvp.IBaseView;
import com.tong.library.utils.EventBusUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter<V>,V extends IBaseView> extends AppCompatActivity implements IBaseView {

    private Unbinder mUnbinder;
    private Activity activity;
    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        mUnbinder = ButterKnife.bind(this);
        activity = this;
        mPresenter = initPresenter();
        init(savedInstanceState);
    }

    protected abstract int getLayoutResID();

    protected abstract P initPresenter();

    protected abstract void init(Bundle savedInstanceState);

    public Activity getActivity() {
        return activity;
    }

    protected boolean isUseEventBus(){
        return false;
    }

    protected P getP(){
        return mPresenter;
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
        mPresenter.detachView();
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

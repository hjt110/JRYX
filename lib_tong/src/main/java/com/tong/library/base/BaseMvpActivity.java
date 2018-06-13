package com.tong.library.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tong.library.mvp.BasePresenter;
import com.tong.library.mvp.IBaseView;

public abstract class BaseMvpActivity<P extends BasePresenter<V>,V extends IBaseView> extends BaseActivity implements IBaseView{

    private P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    protected abstract P initPresenter();

    protected P getP(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }
}

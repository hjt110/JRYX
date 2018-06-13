package com.tong.library.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.mvp.BasePresenter;
import com.tong.library.mvp.IBaseView;

public abstract class BaseMvpFragment<P extends BasePresenter<V>,V extends IBaseView> extends BaseFragment {

    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract P initPresenter();

    protected P getP(){
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}

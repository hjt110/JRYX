package com.tong.library.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tong.library.mvp.BasePresenter;
import com.tong.library.mvp.IBaseView;
import com.tong.library.utils.EventBusUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter<V>,V extends IBaseView> extends Fragment implements IBaseView {

    private Unbinder mUnbinder;

    private P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResID(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        mPresenter = initPresenter();
        init(savedInstanceState);
        return view;
    }

    protected abstract int getLayoutResID();

    protected abstract P initPresenter();

    protected abstract void init(Bundle savedInstanceState);

    protected boolean isUseEventBus(){
        return false;
    }

    protected P getP(){
        return mPresenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isUseEventBus()){
            EventBusUtils.register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (isUseEventBus()){
            EventBusUtils.unregister(this);
        }
    }
}

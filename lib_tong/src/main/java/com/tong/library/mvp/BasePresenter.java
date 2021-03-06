package com.tong.library.mvp;

import android.util.Log;

/**
 * Created by Tong on 2018/4/23.
 */

public abstract class BasePresenter<V extends IBaseView> {

    protected V mView;

    public BasePresenter(V view) {
        attachView(view);
    }

    private void attachView(V view) {
        this.mView = view;
    }

    public V getView() {
        return mView;
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

}

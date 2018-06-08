package com.wangou.jinriyixing.ui.activity.main;

import com.tong.library.mvp.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View> {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    public String add(String msg){
        return msg+"hahah";
    }

}

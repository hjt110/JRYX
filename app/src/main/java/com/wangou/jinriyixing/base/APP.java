package com.wangou.jinriyixing.base;

import android.app.Application;
import android.content.Context;

import com.tong.library.utils.Utils;

public class APP extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Utils.init(this);

    }

    public static Context getContext(){
        return context;
    }


}

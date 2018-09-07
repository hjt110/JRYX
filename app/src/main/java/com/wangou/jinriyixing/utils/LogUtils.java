package com.wangou.jinriyixing.utils;

import android.util.Log;

public class LogUtils {

    private static boolean isLog = true;

    public static void e(String tag,String msg){
        if (isLog){
            Log.e(tag,msg);
        }
    }

    public static void success(String msg){
        if (isLog){
            Log.e("success",msg);
        }
    }

    public static void onError(String msg){
        if (isLog){
            Log.e("onError",msg);
        }
    }
}

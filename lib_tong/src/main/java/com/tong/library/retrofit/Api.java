package com.tong.library.retrofit;

import com.tong.library.retrofit.config.HttpConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Tong on 2018/4/20.
 */

public class Api {

    private static RetrofitService mRetrofitService = null;

    //单例模式
    public static RetrofitService getInstance() {
        if (mRetrofitService == null) {
            synchronized (Api.class) {
                if (mRetrofitService == null) {
                    Retrofit build = new Retrofit.Builder().baseUrl(HttpConfig.BASE_URL)
                            .addConverterFactory(ScalarsConverterFactory.create())//结果以String返回
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                    mRetrofitService = build.create(RetrofitService.class);
                }
            }
        }
        return mRetrofitService;
    }

}

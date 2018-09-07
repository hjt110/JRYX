package com.tong.library.retrofit;



import com.tong.library.bean.BaseBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


/**
 * Created by Tong on 2018/4/20.
 */

public interface RetrofitService {

    @FormUrlEncoded
    @POST("Common/getcode")
    Observable<BaseBean> getCode(@HeaderMap Map<String,String> map, @Field("param")String param);

}

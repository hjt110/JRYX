package com.tong.library.retrofit;

import com.tong.library.bean.BaseBean;
import com.tong.library.bean.NewsContentBean;
import com.tong.library.bean.NewsTitleBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Tong on 2018/4/20.
 */

public interface RetrofitService {

    @FormUrlEncoded
    @POST("Common/getcode")
    Observable<BaseBean> getCode(@HeaderMap Map<String,String> map, @Field("param")String param);

    @FormUrlEncoded
    @POST("{path}")
    Observable<Object> normalRequest(@Path("path") String path,@HeaderMap Map<String,String> map, @Field("param")String param);

    @GET("News/getNewsMenu")
    Observable<NewsTitleBean> getNewsTitle(@HeaderMap Map<String,String> headMap);

    @FormUrlEncoded
    @POST("News/getNewsList")
    Observable<NewsContentBean> getNewsContent(@HeaderMap Map<String,String>headMap, @FieldMap Map<String,String> pramMap);
}

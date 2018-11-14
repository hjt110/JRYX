package com.wangou.jinriyixing.base;

import com.tong.library.bean.BannerBean;
import com.tong.library.bean.BaseBean;
import com.tong.library.bean.FollowBean;
import com.tong.library.retrofit.Api;
import com.tong.library.retrofit.BaseObsever;
import com.tong.library.retrofit.RetrofitService;
import com.tong.library.retrofit.RxSchedulers;
import com.tong.library.retrofit.config.HttpConfig;
import com.wangou.jinriyixing.utils.GlideImageLoader;
import com.wangou.jinriyixing.utils.ParamUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RequestHelper {

    public static void getCode(String phone, String type, MyCallback myCallback) {
        Map<String, String> headerMap = ParamUtils.getHeaderMap();
        Map<String, String> map = new HashMap<>();
        map.put("time", ParamUtils.TimeCurrent);
        map.put("type", type);
        map.put("mobile", phone);
        String param = ParamUtils.getParam(map);
        Api.getInstance()
                .getCode(headerMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(baseBean -> myCallback.onSuccess(baseBean));
    }

    public static void normalRequest(String path, Map<String, String> hearderMap, String param, MyCallback myCallback) {
        Api.getInstance()
                .normalRequest(path, hearderMap, param)
                .compose(RxSchedulers.io_main())
                .subscribe(o -> myCallback.onSuccess(o));
    }

    public static void initBanner(String typeId, Banner banner) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("typeid", typeId);
        paramMap.put("limit", "");
        Api.getInstance()
                .getBanner(ParamUtils.getNormalHeaderMap(), paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<BannerBean>() {
                    @Override
                    public void onSuccess(BannerBean bannerBean) {
                        if (bannerBean.getCode() == 0) {
                            List<BannerBean.DataBean> data = bannerBean.getData();
                            List<String> imgList = new ArrayList<>();
                            for (int i = 0; i < data.size(); i++) {
                                imgList.add(data.get(i).getPlug_ad_pic());
                                banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();
                            }
                        }
                    }
                });
    }

    public static void initFollow(String memberid){
        Retrofit build = new Retrofit.Builder().baseUrl("http://localhost/yxapi/api/")
                .addConverterFactory(ScalarsConverterFactory.create())//结果以String返回
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        RetrofitService service = build.create(RetrofitService.class);
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("memberid",memberid);
        Api.getInstance().getFollow(ParamUtils.getHeaderMapWithToken(),paramMap)
                .compose(RxSchedulers.io_main())
                .subscribe(new BaseObsever<FollowBean>() {
                    @Override
                    public void onSuccess(FollowBean followBean) {
                        if (followBean.getCode()==0){
                            int code = followBean.getCode();
                        }
                    }
                });
    }

}

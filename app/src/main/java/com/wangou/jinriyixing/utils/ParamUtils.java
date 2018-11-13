package com.wangou.jinriyixing.utils;

import com.wangou.jinriyixing.base.APP;
import com.wangou.jinriyixing.db.account.UserAccount;

import java.util.HashMap;
import java.util.Map;

public class ParamUtils {

    public static String TimeCurrent = "";
    private static String Key = "";

    /**
     * getHeaderMap()这个方法一定要在getParam()这个方法之前调用~给TimeCurrent和Key赋值
     *
     * @return
     */
    public static Map<String, String> getHeaderMap() {
        Map<String, String> map = new HashMap<>();
        map.put("time", getTimeCurrent());
        map.put("key", getKey());
        String result = UsefulUtils.mapToJson(map);
        String rsaResult = RsaUtils.encryptByPublic(result);
        Map<String, String> map2 = new HashMap<>();
        map2.put("deviceid", DeviceUtils.getUniqueId(APP.getContext()));
        map2.put("sign", rsaResult.replaceAll("\\s*", ""));
        return map2;
    }

    public static String getParam(Map<String, String> map) {
        if (TimeCurrent.equals("")) {
            throw new IllegalArgumentException("getHeaderMap()这个方法一定要在getParam()这个方法之前调用~给TimeCurrent和Key赋值");
        }
        String s = UsefulUtils.mapToJson(map);
        String encrypt = AesEncryptionUtil.encrypt(s, Key, AesEncryptionUtil.IV);
        TimeCurrent = "";
        return encrypt;
    }

    private static String getTimeCurrent() {
        TimeCurrent = System.currentTimeMillis() / 1000 + "";
        return TimeCurrent;
    }

    private static String getKey() {
        Key = "";
        for (int i = 0; i < 16; i++) {
            Key += String.valueOf((int) (Math.random() * 10));
        }
        return Key;
    }

    /***********************liufang的接口参数*****************************************/
    public static Map<String, String> getNormalHeaderMap() {
        Map<String, String> map = new HashMap<>();
        map.put("deviceid",DeviceUtils.getUniqueId());
        map.put("time", getTimeCurrent());
        return map;
    }
    public static Map<String, String> getHeaderMapWithToken() {
        Map<String, String> map = new HashMap<>();
        map.put("deviceid",DeviceUtils.getUniqueId());
        map.put("time", getTimeCurrent());
        map.put("token", UserAccount.getInstance().getToken());
        return map;
    }
}

package com.tong.library.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * JSON解析工具 (使用Gson)
 * Created by linzb on 16-1-27.
 */
public class JsonUtil {
    private static final String TAG = "JsonUtil";
    private static Gson gson = null;
    private static JsonUtil jsonUtil = null;

    private JsonUtil() {
        gson = new GsonBuilder().serializeNulls().create();
    }

    public static JsonUtil getInstance() {
        if(jsonUtil == null) {
            jsonUtil = new JsonUtil();
        }
        return jsonUtil;
    }

    /**
     * 将对象转换为JSON字符串
     * @param obj
     * @return
     */
    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 将JSON字符串转化为对象
     * @param s
     * @param cls
     * @return
     */
    public <T>T fromJson(String s, Type cls) {
        return gson.fromJson(s.trim(), cls);
    }

}

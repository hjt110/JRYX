package com.wangou.jinriyixing.utils;

import com.google.gson.Gson;

import java.util.Map;

public class UsefulUtils {

    /**
     * 将Map转化为Json字符串
     *
     * @param map
     * @return String
     */
    public static <T> String mapToJson(Map<String, T> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
}

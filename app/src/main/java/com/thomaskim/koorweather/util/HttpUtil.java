package com.thomaskim.koorweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ThomasKim on 2017/1/11.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String ipAddress,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(ipAddress).build();
        client.newCall(request).enqueue(callback);
    }
}

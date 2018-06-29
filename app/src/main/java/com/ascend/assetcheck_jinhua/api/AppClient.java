package com.ascend.assetcheck_jinhua.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：lishanhui on 2018-05-21.
 * 描述：联网 请求
 */

public class AppClient {
    private static final String url = "https://api.yeeuu.com/";
    public static String SynchroDataPath = "https://alms.yeeuu.com/apartments/synchronize_apartments";
    private static Retrofit retrofit;
    private static LockApi lockApi;

    public static LockApi getLockApi() {
        if (lockApi == null) {
            synchronized (AppClient.class) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS);
                OkHttpClient client = builder.build();
                retrofit = new Retrofit.Builder()
                        .client(client)
                        .baseUrl(url)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                lockApi = retrofit.create(LockApi.class);
            }
        }
        return lockApi;
    }

    public static LockApi getLockApi(String urlPath) {
        if (lockApi == null) {
            synchronized (AppClient.class) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder()
                        .connectTimeout(10, TimeUnit.SECONDS);
                OkHttpClient client = builder.build();
                retrofit = new Retrofit.Builder()
                        .client(client)
                        .baseUrl(urlPath)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                lockApi = retrofit.create(LockApi.class);
            }
        }
        return lockApi;
    }
}

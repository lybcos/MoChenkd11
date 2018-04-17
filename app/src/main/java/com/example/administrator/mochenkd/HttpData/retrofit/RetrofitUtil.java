package com.example.administrator.mochenkd.HttpData.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/4/9.
 */

public class RetrofitUtil {
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    public RetrofitUtil() {

    }

    public static Retrofit getRetrofit(String baseUrl) {
        if (okHttpClient == null) {
            okHttpClient = OkHttp3Utils.getOkHttpClient();
        }
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}

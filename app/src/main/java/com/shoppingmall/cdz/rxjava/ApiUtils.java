package com.shoppingmall.cdz.rxjava;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author yichao
 * Dest  得到访问网络api
 */
public class ApiUtils {

    private static OkHttpClient.Builder sBuilder = new OkHttpClient().newBuilder();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create(new Gson());
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static Api sApi;
    public static Api getApi() {

        if (sApi == null) {
            sBuilder.readTimeout(10, TimeUnit.SECONDS);
            sBuilder.connectTimeout(10, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()
                    .client(sBuilder.build())
                    .baseUrl(Api.isRelease ? Api.baseUrl : Api.testBaseUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sApi = retrofit.create(Api.class);
        }
        return sApi;
    }

    public static Api getApi2() {

        if (sApi == null) {
            sBuilder.readTimeout(10, TimeUnit.SECONDS);
            sBuilder.connectTimeout(10, TimeUnit.SECONDS);
            Retrofit retrofit = new Retrofit.Builder()
//                    .client(sBuilder.build())
                    .baseUrl(Api.isRelease ? Api.baseUrl : Api.testBaseUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            sApi = retrofit.create(Api.class);
        }
        return sApi;
    }




}

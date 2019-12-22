package com.webkeyz.batchtwotraining.network;

import com.webkeyz.batchtwotraining.Constants;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit getInstance() {
        return builder.build();
    }

    private static FeedApi feedApi = getInstance().create(FeedApi.class);

    public static FeedApi getFeedApi() {
        return feedApi;
    }
}
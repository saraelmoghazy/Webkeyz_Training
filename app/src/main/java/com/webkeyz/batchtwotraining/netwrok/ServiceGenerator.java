package com.webkeyz.batchtwotraining.netwrok;

import com.webkeyz.batchtwotraining.response.RxErrorHandlingCallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static String BASE_URL = "https://webkeyztest.getsandbox.com";

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit getInstance()
    {
        CustomInterceptor customInterceptor = new CustomInterceptor();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        logging.level(HttpLoggingInterceptor.Level.HEADERS);
        logging.redactHeader("Authorization");
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .addInterceptor(customInterceptor)
                .build();
        return builder.client(client).build();

    }
    private static HotelsApi hotelApi = getInstance().create(HotelsApi.class);

    public static HotelsApi getHotelApi() {
        return hotelApi;
    }


}

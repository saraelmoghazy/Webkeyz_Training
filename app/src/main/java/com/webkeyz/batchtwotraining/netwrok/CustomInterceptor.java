package com.webkeyz.batchtwotraining.netwrok;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CustomInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers headers = new Headers.Builder()
                .add("Authorization","123")
                .build();

        Request newRequest = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .headers(headers)
                .method(request.method(), request.body())
                .build();

        Response response = chain.proceed(newRequest);

        return response;
    }
}

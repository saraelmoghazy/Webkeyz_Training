package com.webkeyz.batchtwotraining.network;

import com.webkeyz.batchtwotraining.models.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface FeedApi {

    @GET("/v2/everything")
    Call<Feed> fetchFeed(@Query("q") String q,
                         @Query("apiKey") String apiKey,
                         @Query("page") int page,
                         @Query("pageSize") long pageSize);
}

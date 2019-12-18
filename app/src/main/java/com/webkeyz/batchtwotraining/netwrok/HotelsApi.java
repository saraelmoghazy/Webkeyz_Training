package com.webkeyz.batchtwotraining.netwrok;

import com.webkeyz.batchtwotraining.models.Hotels;
import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.response.ErrorResponse;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HotelsApi {

    @GET("https://solitary-smoke-1730.getsandbox.com/hello")
    Observable<Hotels> getHotels();

    @POST("https://solitary-smoke-1730.getsandbox.com/users")
    Observable<Void> postHotels(@Body User user);
}

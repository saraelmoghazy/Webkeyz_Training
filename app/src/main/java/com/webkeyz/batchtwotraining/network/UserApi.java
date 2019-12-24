package com.webkeyz.batchtwotraining.network;

import com.webkeyz.batchtwotraining.models.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserApi {

    @GET("users")
    Single<List<User>> getUsers();
}

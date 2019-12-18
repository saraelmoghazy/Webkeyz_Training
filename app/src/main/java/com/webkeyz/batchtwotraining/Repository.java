package com.webkeyz.batchtwotraining;

import android.util.Log;

import com.webkeyz.batchtwotraining.models.Hotels;
import com.webkeyz.batchtwotraining.models.Summary;
import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.netwrok.ServiceGenerator;
import com.webkeyz.batchtwotraining.response.ErrorResponse;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Repository {
    private static final String TAG = "Repository";
    public Observable<Hotels> getHotels(){
        return ServiceGenerator.getHotelApi()
                .getHotels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
    public Observable<Void> postHotels(User user){
        return ServiceGenerator.getHotelApi()
                .postHotels(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

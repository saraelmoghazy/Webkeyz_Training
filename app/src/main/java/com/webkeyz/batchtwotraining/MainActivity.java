package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.webkeyz.batchtwotraining.models.Hotels;
import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.response.ErrorResponse;
import com.webkeyz.batchtwotraining.response.RetrofitException;

import java.io.IOException;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    Repository repository;
    CompositeDisposable disposable;
    User user;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository();
        disposable = new CompositeDisposable();
        user = new User("hady");
        getHotels();
        postHotels(user);
    }

    public void postHotels(User user){
        repository.postHotels(user)
                .subscribe(new Observer<Void>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Void v) {
                        Log.d(TAG, "onNext: post successful to api");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError post failed: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getHotels() {
        repository.getHotels().subscribe(new Observer<Hotels>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Hotels hotels) {
                Log.d(TAG, "onNext: " + hotels.getHotel().get(0).getSummary().getHotelName());
            }

            @Override
            public void onError(Throwable e) {
                RetrofitException retrofitException = (RetrofitException) e;
                ErrorResponse errorResponse;
                try {
                    errorResponse = retrofitException.getErrorBodyAs(ErrorResponse.class);
                    String status = errorResponse.getStatus();
                    int code = errorResponse.getCode();
                    Log.d(TAG, "onError: status: " + status);
                    Log.d(TAG, "onError: code: " + code);
                } catch (IOException ex) {
                    Log.d(TAG, "onError: " + ex.getMessage());
                }
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

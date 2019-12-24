package com.webkeyz.batchtwotraining.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.network.UserApi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {
    private static final String TAG = "UserViewModel";

    private UserApi userApi;
    private MutableLiveData<List<User>> userLiveData = new MutableLiveData<>();

    @Inject
    public UserViewModel(UserApi userApi) {
        this.userApi = userApi;
        getUsers();
        Log.d(TAG, "UserViewModel: CALLED");
    }

    public LiveData<List<User>> getUserLiveData() {
        Log.d(TAG, "getUserLiveData: CALLED");
        return userLiveData;
    }

    private void getUsers() {
        userApi.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        userLiveData.postValue(users);
                        Log.d(TAG, "onSuccess: " + users.get(0).getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }
                });
    }
}
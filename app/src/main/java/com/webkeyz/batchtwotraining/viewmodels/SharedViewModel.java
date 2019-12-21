package com.webkeyz.batchtwotraining.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.webkeyz.batchtwotraining.model.User;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<User> user = new MutableLiveData<>();

    public void select(User user) {
        this.user.setValue(user);
    }

    public LiveData<User> getUser() {
        return user;
    }
}

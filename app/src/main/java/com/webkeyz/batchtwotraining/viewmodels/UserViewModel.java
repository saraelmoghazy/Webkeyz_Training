package com.webkeyz.batchtwotraining.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.reository.UserRepository;

import java.util.List;

import io.reactivex.Completable;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
//    private PagedList.Config config;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
    }

    public LiveData<PagedList<User>> getUsers() {
        return userRepository.searchUsers();
    }

    public Completable insertUser(List<User> users) {
        return userRepository.insertUser(users);
    }

    public Completable deleteUsers(){
        return userRepository.deleteUsers();
    }

}

package com.webkeyz.batchtwotraining.reository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.persistence.UserDao;
import com.webkeyz.batchtwotraining.persistence.UserDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
    private static final String TAG = "UserRepository";
    private static UserRepository instance;
    private UserDao userDao;
    private PagedList.Config pageListConfig;

    private UserRepository(Context context) {
        userDao = UserDatabase.getInstance(context).getUserDao();
        pageListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(20)
                .setPageSize(20)
                .build();
    }

    public static UserRepository getInstance(Context context) {
        if (instance == null) {
            instance = new UserRepository(context);
        }
        return instance;
    }

    public Completable insertUser(List<User> users) {
        return userDao.insertUser(users)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public LiveData<PagedList<User>> searchUsers() {
        LiveData<PagedList<User>> userLiveData = new LivePagedListBuilder<>(getUsers(), pageListConfig)
                .build();
        return userLiveData;
    }

    private DataSource.Factory<Integer, User> getUsers() {
        return userDao.getUsers();
    }

    public Completable deleteUsers() {
        return userDao.deleteUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

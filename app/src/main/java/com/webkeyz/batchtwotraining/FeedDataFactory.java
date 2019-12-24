package com.webkeyz.batchtwotraining;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class FeedDataFactory extends DataSource.Factory {
    private FeedDataSource feedDataSource;
    private MutableLiveData<FeedDataSource> sourceMutableLiveData = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        feedDataSource = new FeedDataSource();
        sourceMutableLiveData.postValue(feedDataSource);
        return feedDataSource;
    }

    public LiveData<FeedDataSource> getSourceMutableLiveData() {
        return sourceMutableLiveData;
    }
}
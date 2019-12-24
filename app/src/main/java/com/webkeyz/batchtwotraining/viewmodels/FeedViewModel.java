package com.webkeyz.batchtwotraining.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.webkeyz.batchtwotraining.FeedDataFactory;
import com.webkeyz.batchtwotraining.models.ArticlesItem;
import com.webkeyz.batchtwotraining.utils.NetworkState;

public class FeedViewModel extends ViewModel {
    private static final String TAG = "FeedViewModel";
    private LiveData<PagedList<ArticlesItem>> pagedListLiveData;
    private FeedDataFactory feedDataFactory;
    private LiveData<NetworkState> networkStateLiveData;

    public FeedViewModel() {
        init();
    }

    private void init() {
        feedDataFactory = new FeedDataFactory();
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(40)
                .setPageSize(20)
                .build();
        pagedListLiveData = (new LivePagedListBuilder(feedDataFactory, pagedListConfig)).build();
    }

    public LiveData<PagedList<ArticlesItem>> getPagedListLiveData() {
        return pagedListLiveData;
    }

    public LiveData<NetworkState> getNetworkState() {
        networkStateLiveData = Transformations.switchMap(feedDataFactory.getSourceMutableLiveData(), input -> input.getNetworkState());
        Log.d(TAG, "FeedViewModel: " + networkStateLiveData);
        return networkStateLiveData;
    }
}
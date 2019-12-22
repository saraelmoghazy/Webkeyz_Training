package com.webkeyz.batchtwotraining.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.webkeyz.batchtwotraining.FeedDataFactory;
import com.webkeyz.batchtwotraining.models.ArticlesItem;

public class FeedViewModel extends AndroidViewModel {

    private LiveData<PagedList<ArticlesItem>> pagedListLiveData;

    public FeedViewModel(@NonNull Application application) {
        super(application);
        init();
    }

    private void init() {
        FeedDataFactory feedDataFactory = new FeedDataFactory();
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .setPageSize(20)
                .build();

        pagedListLiveData = (new LivePagedListBuilder(feedDataFactory, pagedListConfig)).build();
    }

    public LiveData<PagedList<ArticlesItem>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}

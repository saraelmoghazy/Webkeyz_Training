package com.webkeyz.batchtwotraining;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.webkeyz.batchtwotraining.models.ArticlesItem;
import com.webkeyz.batchtwotraining.models.Feed;
import com.webkeyz.batchtwotraining.network.FeedApi;
import com.webkeyz.batchtwotraining.network.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedDataSource extends PageKeyedDataSource<Integer, ArticlesItem> {
    private static final String TAG = "FeedDataSource";
    private FeedApi feedApi;

    public FeedDataSource() {
        feedApi = ServiceGenerator.getFeedApi();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ArticlesItem> callback) {
        feedApi.fetchFeed(Constants.QUERY, Constants.API_KEY, 1, params.requestedLoadSize)
                .enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        callback.onResult(response.body().getArticles(), null, 2);
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ArticlesItem> callback) {
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ArticlesItem> callback) {
        Log.d(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);
        feedApi.fetchFeed(Constants.QUERY, Constants.API_KEY, params.key, params.requestedLoadSize)
                .enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: " + response.body().toString());
                            int nextKey = (params.key == response.body().getTotalResults()) ? null : params.key + 1;
                            callback.onResult(response.body().getArticles(), nextKey);
                        } else {
                            Log.d(TAG, "onResponse: " + response.errorBody());
                            Log.d(TAG, "onResponse: " + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        Log.d(TAG, "onFailure: " + t.toString());
                    }
                });
    }
}
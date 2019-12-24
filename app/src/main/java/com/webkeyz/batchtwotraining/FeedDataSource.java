package com.webkeyz.batchtwotraining;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.webkeyz.batchtwotraining.models.ArticlesItem;
import com.webkeyz.batchtwotraining.models.Feed;
import com.webkeyz.batchtwotraining.network.FeedApi;
import com.webkeyz.batchtwotraining.network.ServiceGenerator;
import com.webkeyz.batchtwotraining.utils.Constants;
import com.webkeyz.batchtwotraining.utils.NetworkState;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedDataSource extends PageKeyedDataSource<Integer, ArticlesItem> {
    private static final String TAG = "FeedDataSource";
    private FeedApi feedApi;
    private MutableLiveData<NetworkState> networkState;

    public FeedDataSource() {
        feedApi = ServiceGenerator.getFeedApi();
        networkState = new MutableLiveData<>();
    }

    public LiveData<NetworkState> getNetworkState() {
        return networkState;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ArticlesItem> callback) {
        networkState.postValue(NetworkState.initialLoading(true));
        feedApi.fetchFeed(Constants.QUERY, Constants.API_KEY, 1, params.requestedLoadSize)
                .enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        if (response.isSuccessful()) {
                            callback.onResult(response.body().getArticles(), null, 2);
                            networkState.postValue(NetworkState.success(response));
                        } else {
                            networkState.postValue(NetworkState.error(response.message()));
                            Log.d(TAG, "onResponse: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        networkState.postValue(NetworkState.error(t.getMessage()));
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, ArticlesItem> callback) {
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ArticlesItem> callback) {
        networkState.postValue(NetworkState.loading(true));
        Log.d(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);
        feedApi.fetchFeed(Constants.QUERY, Constants.API_KEY, params.key, params.requestedLoadSize)
                .enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse: " + response.body().toString());
                            int nextKey = (params.key == response.body().getTotalResults()) ? null : params.key + 1;
                            callback.onResult(response.body().getArticles(), nextKey);
                            networkState.postValue(NetworkState.success(response));
                        } else {
                            Log.d(TAG, "onResponse: " + response.errorBody());
                            Log.d(TAG, "onResponse: " + response.code());
                            networkState.postValue(NetworkState.error(response.message()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                        Log.d(TAG, "onFailure: " + t.toString());
                        networkState.postValue(NetworkState.error(t.getMessage()));
                    }
                });
    }
}
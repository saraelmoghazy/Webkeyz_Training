package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.webkeyz.batchtwotraining.adapters.FeedAdapter;
import com.webkeyz.batchtwotraining.databinding.ActivityMainBinding;
import com.webkeyz.batchtwotraining.utils.NetworkState;
import com.webkeyz.batchtwotraining.viewmodels.FeedViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FeedViewModel feedViewModel;
    private FeedAdapter feedAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        feedViewModel = new ViewModelProvider.NewInstanceFactory().create(FeedViewModel.class);
        feedAdapter = new FeedAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(feedAdapter);
        feedViewModel.getPagedListLiveData().observe(MainActivity.this, articlesItems -> feedAdapter.submitList(articlesItems));
        feedViewModel.getNetworkState().observe(this, networkState -> {
            feedAdapter.setNetworkState(networkState);
            showInitialProgressbar(networkState);
        });
    }

    private void showInitialProgressbar(NetworkState networkState) {
        if (networkState.status == NetworkState.Status.INITIAL_LOADING) {
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }
}
package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.adapters.FeedAdapter;
import com.webkeyz.batchtwotraining.utils.NetworkState;
import com.webkeyz.batchtwotraining.viewmodels.FeedViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FeedViewModel feedViewModel;
    private FeedAdapter feedAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recyclerView);
        feedViewModel = new ViewModelProvider.NewInstanceFactory().create(FeedViewModel.class);
        feedAdapter = new FeedAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(feedAdapter);
        feedViewModel.getPagedListLiveData().observe(MainActivity.this, articlesItems -> feedAdapter.submitList(articlesItems));
        feedViewModel.getNetworkState().observe(this, networkState -> {
            feedAdapter.setNetworkState(networkState);
            showInitialProgressbar(networkState);
        });
    }

    private void showInitialProgressbar(NetworkState networkState) {
        if (networkState.status == NetworkState.Status.INITIAL_LOADING) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
package com.webkeyz.batchtwotraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.adapters.FeedAdapter;
import com.webkeyz.batchtwotraining.models.ArticlesItem;
import com.webkeyz.batchtwotraining.viewmodels.FeedViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private FeedViewModel feedViewModel;
    private FeedAdapter feedAdapter;
    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
        feedAdapter = new FeedAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(feedAdapter);

        feedViewModel.getPagedListLiveData().observe(MainActivity.this, new Observer<PagedList<ArticlesItem>>() {
            @Override
            public void onChanged(PagedList<ArticlesItem> articlesItems) {
                feedAdapter.submitList(articlesItems);
            }
        });
    }
}
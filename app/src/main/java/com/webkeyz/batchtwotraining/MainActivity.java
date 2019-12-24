package com.webkeyz.batchtwotraining;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.adapters.UserAdapter;
import com.webkeyz.batchtwotraining.viewmodels.UserViewModel;
import com.webkeyz.batchtwotraining.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private UserViewModel userViewModel;
    private RecyclerView recyclerView;
    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    @Inject
    UserAdapter userAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel = viewModelProviderFactory.create(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, users -> {
            userAdapter.setUserList(users);
            recyclerView.setAdapter(userAdapter);
        });
    }
}
package com.webkeyz.batchtwotraining;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.webkeyz.batchtwotraining.adapters.UserAdapter;
import com.webkeyz.batchtwotraining.databinding.ActivityMainBinding;
import com.webkeyz.batchtwotraining.viewmodels.UserViewModel;
import com.webkeyz.batchtwotraining.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private UserViewModel userViewModel;
    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    @Inject
    UserAdapter userAdapter;
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userViewModel = viewModelProviderFactory.create(UserViewModel.class);
        userViewModel.getUserLiveData().observe(this, users -> {
            userAdapter.setUserList(users);
            binding.recyclerView.setAdapter(userAdapter);
        });
    }
}
package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.adapters.UserAdapter;
import com.webkeyz.batchtwotraining.models.User;
import com.webkeyz.batchtwotraining.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private UserViewModel userViewModel;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < 80; i++) {
//            User user = new User("a" + i, "0" + i);
//            users.add(user);
//        }

        userAdapter = new UserAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> users = new ArrayList<>();
                for (int i = 1; i <= 60; i++) {
                    User user = new User("a" + i, "0" + i);
                    users.add(user);
                    insertUsers(users);
                }
            }
        });

        findViewById(R.id.get_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsers();
            }
        });

        findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteUsers();
            }
        });

    }

    public void getUsers() {
        userViewModel.getUsers().observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(final PagedList<User> users) {
                Log.d(TAG, "onChanged:get size " + users.size());
                Log.d(TAG, "onChanged: loaded size: " + users.getLoadedCount());
                users.loadAround(users.size() - 1);
                userAdapter.submitList(users);

            }
        });
    }

    public void insertUsers(final List<User> users) {
        userViewModel.insertUser(users)
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: CALLED");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void deleteUsers() {
        userViewModel.deleteUsers().subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: DELETED");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }
        });
    }
}

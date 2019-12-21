package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.webkeyz.batchtwotraining.adapters.UserAdapter;
import com.webkeyz.batchtwotraining.model.User;
import com.webkeyz.batchtwotraining.model.UserUtil;
import com.webkeyz.batchtwotraining.viewmodels.SharedViewModel;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements UserAdapter.OnUserClickListener {
    private static final String TAG = "Fragment1";
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private List<User> users;
    private SharedViewModel sharedViewModel;
    private View rootView;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        users = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        users.addAll(UserUtil.CreateUsers());
        adapter = new UserAdapter(this, users);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onUserClicked(int position) {
        Log.d(TAG, "onUserClicked: " + users.get(position).getName());
        sharedViewModel.select(users.get(position));
        NavDirections action = Fragment1Directions.actionFragment1ToFragment2();
        Navigation.findNavController(recyclerView).navigate(action);
    }
}
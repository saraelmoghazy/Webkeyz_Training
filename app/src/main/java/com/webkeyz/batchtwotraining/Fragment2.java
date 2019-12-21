package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.webkeyz.batchtwotraining.model.User;
import com.webkeyz.batchtwotraining.viewmodels.SharedViewModel;

public class Fragment2 extends Fragment {
    private static final String TAG = "Fragment2";
    private SharedViewModel sharedViewModel;
    private TextView name, age;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        name = view.findViewById(R.id.name_fragment2);
        age = view.findViewById(R.id.age_fragment2);
        sharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        sharedViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                name.setText(user.getName());
                age.setText(user.getAge());
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = Fragment2Directions.actionFragment2ToFragment3();
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}
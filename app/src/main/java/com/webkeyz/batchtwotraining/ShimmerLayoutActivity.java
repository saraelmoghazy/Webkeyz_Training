package com.webkeyz.batchtwotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.supercharge.shimmerlayout.ShimmerLayout;

public class ShimmerLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shimmer_layout);

        ShimmerLayout shimmerLayout = findViewById(R.id.shimmerLayout);
        shimmerLayout.startShimmerAnimation();
    }
}

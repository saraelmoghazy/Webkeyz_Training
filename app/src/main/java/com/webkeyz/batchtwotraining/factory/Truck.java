package com.webkeyz.batchtwotraining.factory;

import android.util.Log;

public class Truck implements Vehicle {
    private static final String TAG = "Truck";
    @Override
    public void create() {
        Log.d(TAG, "created truck");
    }
}

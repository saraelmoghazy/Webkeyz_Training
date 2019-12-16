package com.webkeyz.batchtwotraining.factory;

import android.util.Log;

public class SportCar implements Vehicle {
    private static final String TAG = "SportCar";
    @Override
    public void create() {
        Log.d(TAG, "created sportCar");
    }
}

package com.webkeyz.batchtwotraining.factory;

import android.util.Log;

public class Motorcycle implements Vehicle {
    private static final String TAG = "Mototcycle";
    @Override
    public void create() {
        Log.d(TAG, "created motorcycle");
    }
}

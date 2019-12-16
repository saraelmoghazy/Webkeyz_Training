package com.webkeyz.batchtwotraining.adapter;

import android.util.Log;

public class BluetoothDevice {
    private static final String TAG = "BluetoothDevice";
    private String name;

    public BluetoothDevice(String name) {
        this.name = name;
    }

    public void connectBluetoothDevice() {
        Log.d(TAG, name + " connected");
    }
}

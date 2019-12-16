package com.webkeyz.batchtwotraining.observer;

import android.util.Log;

// observer
public class CarOwner implements Observer {
    private static final String TAG = "CarOwner";
    private String name;
    public CarOwner(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(boolean isTurnedOff) {
        if(isTurnedOff){
            Log.d(TAG, name + ", car is turned off");
        }else{
            Log.d(TAG, name + ", car is turned on ");
        }
    }
}

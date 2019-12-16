package com.webkeyz.batchtwotraining.observer;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.webkeyz.batchtwotraining.R;

public class ObserverActivity extends AppCompatActivity {
    private static final String TAG = "ObserverActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        CarState carState = new CarState();
        CarOwner carOwner1 = new CarOwner("owner1");
        CarOwner carOwner2 = new CarOwner("owner2");
        CarOwner carOwner3 = new CarOwner("owner3");

        // register observers
        carState.register(carOwner1);
        carState.register(carOwner2);
        carState.register(carOwner3);
        // notify observers of updates
        carState.setCarState(true);
        carState.notifyObservers();
        // unregister observer
        // turn car off
        // notify observers
        carState.unRegister(carOwner3);
        carState.setCarState(false);
        carState.notifyObservers();
    }
}

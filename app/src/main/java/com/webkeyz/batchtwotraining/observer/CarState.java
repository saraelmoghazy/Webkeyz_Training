package com.webkeyz.batchtwotraining.observer;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//subject
public class CarState implements Subject {
    private static final String TAG = "CarState";
    private boolean turnedOff;
    private List<Observer> observers = new ArrayList<>();

    public void setCarState(boolean turnedOff){
        this.turnedOff = turnedOff;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
        Log.d(TAG, observer.getName() + " is registered");
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observer);
        Log.d(TAG, observer.getName() + " is unRegistered");
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(turnedOff);
        }
    }
}

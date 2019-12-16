package com.webkeyz.batchtwotraining.observer;

public interface Subject {
    void register(Observer observer);
    void unRegister(Observer observer);
    void notifyObservers();

}

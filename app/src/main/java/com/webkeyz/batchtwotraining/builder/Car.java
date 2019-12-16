package com.webkeyz.batchtwotraining.builder;

import androidx.annotation.NonNull;

public class Car {
    private String model;
    private String noOfSeats;
    private String engineType;
    private Car(Builder builder){
        model = builder.model;
        noOfSeats = builder.noOfSeats;
        engineType = builder.engineType;
    }

    @NonNull
    @Override
    public String toString() {
        return "car model: " + model
                + ", engine type: " + engineType
                + ", no of seats: " + noOfSeats;
    }

    public static class Builder{
        private String model;
        private String noOfSeats;
        private String engineType;
        public Builder setModel(String model){
            this.model = model;
            return this;
        }
        public Builder setNoOfSeats(String noOfSeats){
            this.noOfSeats = noOfSeats;
            return this;
        }
        public Builder setEngineType(String engineType){
            this.engineType = engineType;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }
}

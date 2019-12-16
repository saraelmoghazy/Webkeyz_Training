package com.webkeyz.batchtwotraining.factory;

public class VehicleFactory {

    public static Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("truck")){
            return new Truck();
        }else if(type.equalsIgnoreCase("motorcycle")){
            return new Motorcycle();
        }else if(type.equalsIgnoreCase("sportCar")){
            return new SportCar();
        }else{
            return null;
        }
    }
}

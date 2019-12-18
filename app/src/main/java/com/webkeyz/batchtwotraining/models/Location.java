package com.webkeyz.batchtwotraining.models;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("address")
    private String address;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return
                "Location{" +
                        "address = '" + address + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}
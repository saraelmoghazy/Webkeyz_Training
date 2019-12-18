package com.webkeyz.batchtwotraining.models;

import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("highRate")
    private double highRate;

    @SerializedName("lowRate")
    private double lowRate;

    @SerializedName("hotelName")
    private String hotelName;

    public void setHighRate(double highRate) {
        this.highRate = highRate;
    }

    public double getHighRate() {
        return highRate;
    }

    public void setLowRate(double lowRate) {
        this.lowRate = lowRate;
    }

    public double getLowRate() {
        return lowRate;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    @Override
    public String toString() {
        return
                "Summary{" +
                        "highRate = '" + highRate + '\'' +
                        ",lowRate = '" + lowRate + '\'' +
                        ",hotelName = '" + hotelName + '\'' +
                        "}";
    }
}
package com.webkeyz.batchtwotraining.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hotels {

    @SerializedName("hotel")
    private List<HotelItem> hotel;

    public void setHotel(List<HotelItem> hotel) {
        this.hotel = hotel;
    }

    public List<HotelItem> getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return
                "Hotels{" +
                        "hotel = '" + hotel + '\'' +
                        "}";
    }
}
package com.webkeyz.batchtwotraining.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelItem {

    @SerializedName("summary")
    private Summary summary;

    @SerializedName("image")
    private List<ImageItem> image;

    @SerializedName("location")
    private Location location;

    @SerializedName("hotelId")
    private int hotelId;

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setImage(List<ImageItem> image) {
        this.image = image;
    }

    public List<ImageItem> getImage() {
        return image;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    @Override
    public String toString() {
        return
                "HotelItem{" +
                        "summary = '" + summary + '\'' +
                        ",image = '" + image + '\'' +
                        ",location = '" + location + '\'' +
                        ",hotelId = '" + hotelId + '\'' +
                        "}";
    }
}
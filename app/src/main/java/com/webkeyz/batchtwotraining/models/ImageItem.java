package com.webkeyz.batchtwotraining.models;

import com.google.gson.annotations.SerializedName;

public class ImageItem {

    @SerializedName("url")
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "ImageItem{" +
                        "url = '" + url + '\'' +
                        "}";
    }
}
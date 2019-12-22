package com.webkeyz.batchtwotraining.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class ArticlesItem implements Parcelable {

    @SerializedName("publishedAt")
    private String publishedAt;

    @SerializedName("author")
    private String author;

    @SerializedName("urlToImage")
    private String urlToImage;

    @SerializedName("description")
    private String description;

    @SerializedName("source")
    private Source source;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("content")
    private String content;

    protected ArticlesItem(Parcel in) {
        publishedAt = in.readString();
        author = in.readString();
        urlToImage = in.readString();
        description = in.readString();
        title = in.readString();
        url = in.readString();
        content = in.readString();
    }

    public static final Creator<ArticlesItem> CREATOR = new Creator<ArticlesItem>() {
        @Override
        public ArticlesItem createFromParcel(Parcel in) {
            return new ArticlesItem(in);
        }

        @Override
        public ArticlesItem[] newArray(int size) {
            return new ArticlesItem[size];
        }
    };

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return
                "ArticlesItem{" +
                        "publishedAt = '" + publishedAt + '\'' +
                        ",author = '" + author + '\'' +
                        ",urlToImage = '" + urlToImage + '\'' +
                        ",description = '" + description + '\'' +
                        ",source = '" + source + '\'' +
                        ",title = '" + title + '\'' +
                        ",url = '" + url + '\'' +
                        ",content = '" + content + '\'' +
                        "}";
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this)
            return true;

        ArticlesItem article = (ArticlesItem) obj;
        return article.getSource().getId()== this.source.getId();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(publishedAt);
        dest.writeString(author);
        dest.writeString(urlToImage);
        dest.writeString(description);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(content);
    }
}
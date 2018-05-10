package com.example.bs0158.galleryapplication;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("text")
    private String mText;

    @SerializedName("photo")
    private String mPhotoUrl;

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public void setPhotoUrl(String mPhotoUrl) {
        this.mPhotoUrl = mPhotoUrl;
    }
}

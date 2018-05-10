package com.example.bs0158.galleryapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST(".")
    public Call<List<Photo>> getAllPhotosInfo(@Field("authKey") String authKey);
}

package com.example.bs0158.galleryapplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="http://alldevicereview.com/android/";
    private static final String BASE_URL2="http://202.84.43.214:5041/";
    private static Retrofit mRetrofit=null;
    private static Retrofit mRetrofit2=null;

    public static Retrofit getClient(){
        if(mRetrofit ==null){
            mRetrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;

    }

    public static Retrofit getClient2(final String authToken){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Authorization",authToken).build();
                return chain.proceed(request);
            }
        });

        if(mRetrofit2==null){
            mRetrofit2=new Retrofit.Builder().baseUrl(BASE_URL2)
                    .client(httpClient.build()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit2;

    }
}

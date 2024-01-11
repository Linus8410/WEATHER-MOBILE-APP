package com.example.weatherapp;

import com.example.weatherapp.Activities.MausamData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {
    @GET("data/2.5/weather")
    Call<MausamData>getData(
            @Query("q")String q,
            @Query("APPID")String APIKEY,
            @Query("units")String units
    );
}

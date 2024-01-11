package com.example.weatherapp.Activities;

import java.util.List;

public class MausamData {
    private List<weather> weather;
    private main main;
    private String name;


    public MausamData(List<com.example.weatherapp.Activities.weather> weather, com.example.weatherapp.Activities.main main, String name) {
        this.main = main;
        this.weather = weather;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.weatherapp.Activities.main getMain() {
        return main;
    }

    public void setMain(com.example.weatherapp.Activities.main main) {
        this.main = main;
    }

    public List<com.example.weatherapp.Activities.weather> getWeather() {
        return weather;
    }

    public void setWeather(List<com.example.weatherapp.Activities.weather> weather) {
        this.weather = weather;
    }
}



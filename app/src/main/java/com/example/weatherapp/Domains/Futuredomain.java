package com.example.weatherapp.Domains;

public class Futuredomain {
    private String day;
    private String picPath;
    private String Status;
    private String highTemp;
    private int lowTemp;


    public Futuredomain(String day, String picPath, String Status, String highTemp, int lowTemp) {
        this.day = day;
        this.picPath = picPath;
        this.Status= Status;
        this.highTemp = highTemp;
        this.lowTemp = lowTemp;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

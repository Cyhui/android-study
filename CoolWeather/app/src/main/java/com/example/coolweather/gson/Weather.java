package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 54459 on 2017/5/26 0026.
 */

public class Weather {

    public String status;

    public Basic basic;

    public AQI aqi;

    public Now now;

    public Suggestion suggestion;

    /**
     *   daily_forecast 中包含的是一个数组，在这里使用List集合来引用Forecast类
     */
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;


}

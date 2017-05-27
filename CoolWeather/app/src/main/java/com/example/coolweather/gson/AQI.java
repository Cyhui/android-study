package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 54459 on 2017/5/26 0026.
 */

public class AQI {

    public AQICity city;

    public class AQICity{

        public String aqi;

        public String pm25;
    }
}

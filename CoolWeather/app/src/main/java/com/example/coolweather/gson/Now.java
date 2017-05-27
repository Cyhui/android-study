package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 54459 on 2017/5/26 0026.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}

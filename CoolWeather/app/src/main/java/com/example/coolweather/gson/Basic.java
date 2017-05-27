package com.example.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 54459 on 2017/5/26 0026.
 */

public class Basic {

    //JSON字段不太适合直接使用JAVA字段命名
    //@SerializedName注解建立JSON字段和Java字段之间的联系
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{

        @SerializedName("loc")
        public String updateTime;
    }
}

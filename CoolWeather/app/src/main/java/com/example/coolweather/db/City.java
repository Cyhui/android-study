package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by 54459 on 2017/5/11 0011.
 */

public class City extends DataSupport {

    private int id;             //市的id

    private String cityName;    //当前市的名字

    private int cityCode;       //当前市的代号

    private int provinceId;   //当前省的id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}

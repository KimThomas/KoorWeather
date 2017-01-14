package com.thomaskim.koorweather.gson;

/**
 * Created by ThomasKim on 2017/1/12.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}

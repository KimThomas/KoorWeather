package com.thomaskim.koorweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThomasKim on 2017/1/11.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;


    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateLocationTime;
    }
}

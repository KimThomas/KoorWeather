package com.thomaskim.koorweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThomasKim on 2017/1/12.
 */

public class Forecast {
    public String date;

    @SerializedName("cond")
    public Condition condition;

    public class Condition{
        @SerializedName("txt_d")
        public String info;
    }

    @SerializedName("tmp")
    public Temperature temperature;

    public class Temperature {
        public String max;
        public String min;
    }
}

package com.thomaskim.koorweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ThomasKim on 2017/1/12.
 */

/**
 * cond为状态，如晴，阴等
 */
public class Now {
    @SerializedName("tmp")
    public String temperature;


    public Cond cond;

    public class Cond {
        @SerializedName("txt")
        public String info;
    }
}


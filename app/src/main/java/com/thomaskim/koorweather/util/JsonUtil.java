package com.thomaskim.koorweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.thomaskim.koorweather.db.City;
import com.thomaskim.koorweather.db.County;
import com.thomaskim.koorweather.db.Province;
import com.thomaskim.koorweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ThomasKim on 2017/1/11.
 */

public class JsonUtil {

    public static final String JUTAG="JUTAG";

    /**
     * 解析和处理服务器返回的全部省的JSON格式数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject object=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(object.getString("name"));
                    province.setProvinceCode(object.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                LogUtil.d("province",e.getMessage());
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市的JSON格式的数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject object=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(object.getInt("id"));
                    city.setCityName(object.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                LogUtil.d("city",e.getMessage());
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县的JSON格式的数据
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject object=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(object.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(object.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                LogUtil.d("county",e.getMessage());
            }
        }
        return false;
    }

    /**
     * 将返回的JSON格式的数据解析城Weather类
     */
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            LogUtil.d("Weather",e.getMessage());
        }
        return null;
    }
}

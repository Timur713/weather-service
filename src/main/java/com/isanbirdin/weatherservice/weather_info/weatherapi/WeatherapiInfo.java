package com.isanbirdin.weatherservice.weather_info.weatherapi;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherapiInfo {
    private final int temperature;
    private final int windSpeed;
    private final int pressure;
    private final int humidity;
    private final int cloud;

    public WeatherapiInfo(String JSON) {
        try {
            JSONObject obj = new JSONObject(JSON);
            String currentDictionary = String.valueOf(obj.get("current"));
            obj = null;

            JSONObject obj2 = new JSONObject(currentDictionary);
            this.temperature = obj2.getInt("temp_c");
            this.windSpeed = obj2.getInt("wind_kph");
            this.pressure = obj2.getInt("pressure_mb");
            this.humidity = obj2.getInt("humidity");
            this.cloud = obj2.getInt("cloud");
        } catch (JSONException e) {
            throw new JSONException("JSON is invalid");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    @Override
    public String toString() {
        return "WeatherapiInfo{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                '}';
    }
}

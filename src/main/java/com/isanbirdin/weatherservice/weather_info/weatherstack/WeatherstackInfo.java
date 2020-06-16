package com.isanbirdin.weatherservice.weather_info.weatherstack;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherstackInfo {
    private final int temperature;
    private final int windSpeed;
    private final int pressure;
    private final int humidity;

    public WeatherstackInfo(String JSON) {
        try {
            JSONObject obj = new JSONObject(JSON);
            String currentDictionary = String.valueOf(obj.get("current"));
            obj = null;

            JSONObject obj2 = new JSONObject(currentDictionary);
            this.temperature = obj2.getInt("temperature");
            this.windSpeed = obj2.getInt("wind_speed");
            this.pressure = obj2.getInt("pressure");
            this.humidity = obj2.getInt("humidity");
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

    @Override
    public String toString() {
        return "WeatherstackInfo{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }
}

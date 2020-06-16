package com.isanbirdin.weatherservice.service;

import com.isanbirdin.weatherservice.weather_info.ApiConnector;
import com.isanbirdin.weatherservice.weather_info.WeatherApiConnectorConstants;
import com.isanbirdin.weatherservice.weather_info.weatherapi.WeatherapiInfo;
import com.isanbirdin.weatherservice.weather_info.weatherstack.WeatherstackInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    @Cacheable("weather_info")
    public WeatherstackInfo getWeatherstackInfo(String city) throws IOException {
        String response = ApiConnector.makeRequest(city, WeatherApiConnectorConstants.WEATHERTACK_URL, WeatherApiConnectorConstants.WEATHERTACK_HTTP_METHOD);
        return new WeatherstackInfo(response);
    }

    @Cacheable("weather_info")
    public WeatherapiInfo getWeatherapiInfo(String city) throws IOException {
        String response = ApiConnector.makeRequest(city, WeatherApiConnectorConstants.WEATHERAPI_URL, WeatherApiConnectorConstants.WEATHERAPI_HTTP_METHOD);
        return new WeatherapiInfo(response);
    }
}

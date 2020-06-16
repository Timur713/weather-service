package com.isanbirdin.weatherservice.controller;

import com.isanbirdin.weatherservice.service.WeatherService;
import com.isanbirdin.weatherservice.weather_info.weatherapi.WeatherapiInfo;
import com.isanbirdin.weatherservice.weather_info.weatherstack.WeatherstackInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("weatherapi")
public class WeatherapiController {
    private final WeatherService service;

    public WeatherapiController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public String getWeatherapiPage() {
        return "weatherapi";
    }

    @PostMapping
    public String getWeatherInfo(
            @RequestParam(name = "city") String city,
            @RequestParam(name = "temperature", required = false) String temperature,
            @RequestParam(name = "windSpeed", required = false) String windSpeed,
            @RequestParam(name = "pressure", required = false) String pressure,
            @RequestParam(name = "humidity", required = false) String humidity,
            @RequestParam(name = "cloud", required = false) String cloud,
            Model model
    ) throws IOException {

        try {
            WeatherapiInfo info = service.getWeatherapiInfo(city.trim().replace(" ", "%20"));

            model.addAttribute("response_lastRequestCityName", city);
            if (temperature != null) {
                model.addAttribute("response_temperature", info.getTemperature());
            }
            if (windSpeed != null) {
                model.addAttribute("response_windSpeed", info.getWindSpeed());
            }
            if (pressure != null) {
                model.addAttribute("response_pressure", info.getPressure());
            }
            if (humidity != null) {
                model.addAttribute("response_humidity", info.getHumidity());
            }
            if (cloud != null) {
                model.addAttribute("response_cloud", info.getCloud());
            }
        } catch (Exception e) {
            model.addAttribute("response_cityError", "This city doesn't exist");
        }
        return "weatherapi";
    }
}

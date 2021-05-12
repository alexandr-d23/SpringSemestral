package ru.itis.diner.semestral.controllers;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.diner.semestral.services.GameServiceImpl;
import ru.itis.diner.semestral.services.WeatherService;

import java.io.IOException;
import java.util.logging.Level;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping
    public String getWeather(ModelMap map){
        map.put("weather", service.getWeather());
        return "weather";
    }
}

package ru.itis.diner.semestral.services;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.diner.semestral.controllers.WeatherController;
import ru.itis.diner.semestral.model.WeatherResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class WeatherServiceImpl implements WeatherService {


    @Autowired
    private Logger logger;


    @Override
    public WeatherResponse getWeather() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.openweathermap.org/data/2.5/weather?" +
                            "q=Kazan&appid=0648e566e7baac5b2182bcfbffebc538&units=metric")
                    .build();
            Response response = client.newCall(request).execute();
            Gson gson = new Gson();
            WeatherResponse weather = gson.fromJson(response.body().string(), WeatherResponse.class);
            System.out.println(weather.getMain().getFeelsLike());
            return weather;
        } catch (IOException e) {
            logger.log(Level.INFO, WeatherController.class.getName() + "getUserScoreById() :", e);
            return null;
        }
    }
}

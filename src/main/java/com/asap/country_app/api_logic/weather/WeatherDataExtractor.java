package com.asap.country_app.api_logic.weather;

import com.asap.country_app.api_logic.geo.City;
import com.asap.country_app.api_logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataExtractor {

    private final HttpClient httpClient;
    private final HttpResponseToWeatherConverter httpResponseToWeatherConverter;

    @Autowired
    public WeatherDataExtractor(HttpClient httpClient, HttpResponseToWeatherConverter httpResponseToWeatherConverter) {
        this.httpClient = httpClient;
        this.httpResponseToWeatherConverter = httpResponseToWeatherConverter;
    }

    public Weather getWeather(City city) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getWeatherData(city);
        return httpResponseToWeatherConverter.convertResponseToWeather(response);
    }
}

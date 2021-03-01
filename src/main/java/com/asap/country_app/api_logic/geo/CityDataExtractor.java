package com.asap.country_app.api_logic.geo;

import com.asap.country_app.api_logic.rest.HttpClient;
import com.asap.country_app.api_logic.weather.WeatherDataExtractor;
import com.asap.country_app.api_logic.wiki_data.WikiDataExtractor;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDataExtractor {

    private final HttpClient httpClient;
    private final HttpResponseConverter httpResponseConverter;
    private final WeatherDataExtractor weatherDataExtractor;
    private final WikiDataExtractor wikiDataExtractor;
    private final CountryDataExtractor countryDataExtractor;

    @Autowired
    public CityDataExtractor(HttpClient httpClient, HttpResponseConverter httpResponseConverter,
                             WeatherDataExtractor weatherDataExtractor, WikiDataExtractor wikiDataExtractor,
                             CountryDataExtractor countryDataExtractor) {
        this.httpClient = httpClient;
        this.httpResponseConverter = httpResponseConverter;
        this.weatherDataExtractor = weatherDataExtractor;
        this.wikiDataExtractor = wikiDataExtractor;
        this.countryDataExtractor = countryDataExtractor;
    }

    public City getCity(String countryName, String cityName) throws UnirestException {
        Country country = countryDataExtractor.getCountry(countryName);

        HttpResponse<JsonNode> response = httpClient.getCityData(country, cityName);
        City city = httpResponseConverter.convertResponseToCity(response);
        city.setCountry(country);
        city.setWeather(weatherDataExtractor.getWeather(city));
        city.setWikipediaPage(wikiDataExtractor.getData(cityName));
        return city;
    }
}

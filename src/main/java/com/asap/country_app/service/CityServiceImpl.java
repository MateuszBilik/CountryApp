package com.asap.country_app.service;

import com.asap.country_app.api_logic.geo.City;
import com.asap.country_app.api_logic.geo.CityDataExtractor;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityDataExtractor cityDataExtractor;

    public CityServiceImpl(CityDataExtractor cityDataExtractor) {
        this.cityDataExtractor = cityDataExtractor;
    }

    @Override
    public City getCity(String countryName, String cityName) throws UnirestException {
        return cityDataExtractor.getCity(countryName, cityName);
    }
}

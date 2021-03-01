package com.asap.country_app.service;

import com.asap.country_app.api_logic.geo.City;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CityService {

    City getCity(String country, String cityName) throws UnirestException;

}

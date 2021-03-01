package com.asap.country_app.service;

import com.asap.country_app.api_logic.geo.Country;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CountryService {

    Country getCountry(String countryName) throws UnirestException;

}

package com.asap.country_app.service;

import com.asap.country_app.api_logic.geo.Country;
import com.asap.country_app.api_logic.geo.CountryDataExtractor;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryDataExtractor countryDataExtractor;

    public CountryServiceImpl(CountryDataExtractor countryDataExtractor) {
        this.countryDataExtractor = countryDataExtractor;
    }

    @Override
    public Country getCountry(String countryName) throws UnirestException {
        return countryDataExtractor.getCountry(countryName);
    }
}

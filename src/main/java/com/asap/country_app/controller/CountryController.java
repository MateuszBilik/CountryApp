package com.asap.country_app.controller;

import com.asap.country_app.api_logic.geo.Country;
import com.asap.country_app.service.CountryService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/country")
    public Country getInfoForTheCountry(@RequestParam(name = "country") String countryName) {
        try {
            log.info("Country info checked country={}", countryName);
            return countryService.getCountry(countryName);
        } catch (UnirestException e) {
            log.error("Not able to get country{} info {}", countryName, e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}

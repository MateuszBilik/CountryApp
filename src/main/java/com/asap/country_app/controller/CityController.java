package com.asap.country_app.controller;

import com.asap.country_app.service.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CityController {

    private final CityService cityService;
    private final ObjectMapper mapper;

    public CityController(CityService cityService, ObjectMapper mapper) {
        this.cityService = cityService;
        this.mapper = mapper;
    }

    @CrossOrigin
    @GetMapping("/city")
    public String getInfoForTheCity(@RequestParam(name = "country") String countryName,
                                    @RequestParam(name = "city") String cityName) throws JsonProcessingException, UnirestException {
        try {
            log.info("City info checked country={} city={}", countryName, cityName);
            return mapper.writeValueAsString(cityService.getCity(countryName, cityName));
        } catch (JsonProcessingException | UnirestException | JSONException e) {
            log.error("Not able to get city={} info {}", cityName, e.getMessage());
            //TODO or change to JsonProcessingException
//            return mapper.writeValueAsString("There isn't that location, try again");
            throw e;
        }
    }
}

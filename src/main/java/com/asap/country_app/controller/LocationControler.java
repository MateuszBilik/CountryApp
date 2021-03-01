package com.asap.country_app.controller;

import com.asap.country_app.dto.LocationDto;
import com.asap.country_app.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LocationControler {

    private final LocationService locationService;

    public LocationControler(LocationService locationService) {
        this.locationService = locationService;
    }

    @CrossOrigin
    @PostMapping("/location")
    public LocationDto saveLocation(@RequestBody LocationDto locationDto) {
            return locationService.saveLocation(locationDto);
    }
}

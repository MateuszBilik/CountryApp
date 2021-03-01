package com.asap.country_app.service;

import com.asap.country_app.database.repository.LocationRepository;
import com.asap.country_app.database.model.Location;
import com.asap.country_app.dto.LocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.asap.country_app.database.Functions.LocationFunctions.locationDTOToLocation;
import static com.asap.country_app.database.Functions.LocationFunctions.locationToLocationDTO;

@Service
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional
    public LocationDto saveLocation(LocationDto locationDto) {

        Location location = locationRepository.findLocationByCountryAndCity(locationDto.getCountry(), locationDto.getCity());

        if(location == null) {
            location = locationDTOToLocation.apply(locationDto);
            log.info("Save Location");
            return locationToLocationDTO.apply(locationRepository.save(location));
        } else {
            log.warn("Location existed early");
            return locationDto;
        }
    }

    @Transactional
    public Location findByCountryAndCity(String country, String city){
        return locationRepository.findLocationByCountryAndCity(country, city);
    }
}





package com.asap.country_app.database.Functions;

import com.asap.country_app.database.model.Location;
import com.asap.country_app.dto.LocationDto;

import java.util.function.Function;

public class LocationFunctions {

    public static final Function<Location, LocationDto> locationToLocationDTO = location -> new LocationDto(
            location.getId(),
            location.getCountry(),
            location.getCity()
    );

    public static final Function<LocationDto, Location> locationDTOToLocation = locationDto -> new Location(
            locationDto.getCountry(),
            locationDto.getCity()
    );
}

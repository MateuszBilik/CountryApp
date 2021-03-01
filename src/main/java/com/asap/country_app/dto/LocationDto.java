package com.asap.country_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {


    private UUID id;

    private String country;
    private String city;

    private List<AppUserDto> visitedLocationsDto;

    private List<AppUserDto> likedLocationsDto;

    private List<AppUserDto> locationsWantedToVisitDto;

    public LocationDto(UUID id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }
}

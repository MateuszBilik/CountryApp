package com.asap.country_app.api_logic.geo;

import com.asap.country_app.api_logic.weather.Weather;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private Country country;
    private String name;
    private String id;
    private String latitude;
    private String longitude;
    private Weather weather;
    private String wikipediaPage;
}

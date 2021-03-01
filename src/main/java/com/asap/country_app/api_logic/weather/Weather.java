package com.asap.country_app.api_logic.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private int temperature;
    private int sensedTemp;
    private String description;
    private int pressure;
    private double wind;
}

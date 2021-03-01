package com.asap.country_app.api_logic.geo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String wikiId;
    private String currency;
    private String code;
    private String name;
    private double exchangeRate;
    private String wikipediaUrl;
    private String flagUrl;
}

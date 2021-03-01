package com.asap.country_app.service;

import com.mashape.unirest.http.exceptions.UnirestException;

public interface ExchangeRateService {

    String getExchangeRate(String from, String to) throws UnirestException;

}

package com.asap.country_app.api_logic.currency;

import com.asap.country_app.api_logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeDataExtractor {

    private final HttpClient httpClient;

    public CurrencyExchangeDataExtractor(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getExchangeRate(String from, String to) throws UnirestException {
        HttpResponse<String> response = httpClient.getCurrencyExchangeData(from, to);
        return response.getBody();
    }
}

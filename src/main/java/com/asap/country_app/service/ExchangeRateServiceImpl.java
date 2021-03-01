package com.asap.country_app.service;

import com.asap.country_app.api_logic.currency.CurrencyExchangeDataExtractor;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final CurrencyExchangeDataExtractor currencyExchangeDataExtractor;

    public ExchangeRateServiceImpl(CurrencyExchangeDataExtractor currencyExchangeDataExtractor) {
        this.currencyExchangeDataExtractor = currencyExchangeDataExtractor;
    }

    @Override
    public String getExchangeRate(String from, String to) throws UnirestException {
        return currencyExchangeDataExtractor.getExchangeRate(from, to);
    }
}

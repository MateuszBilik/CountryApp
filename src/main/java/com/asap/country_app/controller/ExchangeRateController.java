package com.asap.country_app.controller;

import com.asap.country_app.service.ExchangeRateService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/exchangeRate")
    public String getExchangeRate(@RequestParam(name = "from") String from, @RequestParam(name = "to") String to) {
        try {
            log.info("Exchange rate check from {} to {}", from, to);
            return exchangeRateService.getExchangeRate(from, to);
        } catch (UnirestException e) {
            log.error("Not able to get exchange rate from {} to {} error {}", from, to, e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}

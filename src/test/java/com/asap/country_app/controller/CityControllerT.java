package com.asap.country_app.controller;

import com.asap.country_app.service.CityService;

public class CityControllerT {

    private String json = "{\"country\":{\"wikiId\":\"Q36\",\"currency\":\"[\\\"PLN\\\"]\",\"code\":\"PL\",\"name\":\"Poland\",\"exchangeRate\":1.0,\"wikipediaPage\":\"https://en.wikipedia.org/wiki/Poland\",\"flag\":\"http://commons.wikimedia.org/wiki/Special:FilePath/Flag%20of%20Poland.svg\"},\"name\":\"Kraków\",\"id\":\"159708\",\"latitude\":\"50.061388888\",\"longitude\":\"19.937222222\",\"weather\":{\"temperature\":-12,\"feelsLike\":-16,\"description\":\"light snow\",\"pressure\":1021,\"wind\":1.03},\"wikipediaPage\":\"https://en.wikipedia.org/wiki/Krakow\"}";
    private CityController cityController;
    CityService cityService;

//    @Test
//    void createCityToJSON() {
//        // given
//        Exception exception = new Exception();
//        String city = "Krakow";
//        String city2 = "123";
//        String country = "Poland";
//        given(cityService.getCity(city,country)).willThrow(exception);
//
//        // when
//        cityController.getInfoForTheCity(country, city);
//
//        // then
//        assertEquals("Not able to get city=123 info JSONArray[0] not found.", a)
//        assertThatExceptionOfType(Exception.class).isThrownBy().has
//
//
//    }


}

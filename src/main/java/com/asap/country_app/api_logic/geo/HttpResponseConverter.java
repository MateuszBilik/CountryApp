package com.asap.country_app.api_logic.geo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
class HttpResponseConverter {

    City convertResponseToCity(HttpResponse<JsonNode> response) {
        City city = new City();
        JSONObject data = getJSONObjectFromResponse(response);
        city.setId(data.get("id").toString());
        city.setName(data.get("name").toString());
        city.setLatitude(data.get("latitude").toString());
        city.setLongitude(data.get("longitude").toString());
        return city;
    }

    Country convertResponseToCountry(HttpResponse<JsonNode> response) {
        Country country = new Country();
        JSONObject data = getJSONObjectFromResponse(response);
        country.setWikiId(data.get("wikiDataId").toString());
        country.setCurrency(data.get("currencyCodes").toString().replace("[\"", "").replace("\"]", ""));
        country.setName(data.get("name").toString());
        country.setCode(data.get("code").toString());
        return country;
    }

    String convertResponseToFlag(HttpResponse<JsonNode> response) {
        return response.getBody().getObject().getJSONObject("data").get("flagImageUri").toString();
    }

    private JSONObject getJSONObjectFromResponse(HttpResponse<JsonNode> response) {
        return response.getBody().getObject().getJSONArray("data").getJSONObject(0);
    }
}

package com.asap.country_app.api_logic.wiki_data;

import com.asap.country_app.api_logic.rest.HttpClient;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class WikiDataExtractor {

    private HttpClient httpClient;

    public WikiDataExtractor(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    //TODO make parsing of json via object mapper
    public String getData(String cityName) throws UnirestException {
        HttpResponse<JsonNode> response = httpClient.getWikiData(cityName);
        JSONObject jsonObject = response.getBody().getObject().getJSONObject("query").getJSONObject("pages");
        String jsonKey = jsonObject.keySet().stream().findFirst().orElseThrow();
        return jsonObject.getJSONObject(jsonKey).get("fullurl").toString();
    }

}

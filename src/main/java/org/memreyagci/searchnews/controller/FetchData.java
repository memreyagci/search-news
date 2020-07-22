package org.memreyagci.searchnews.controller;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class FetchData {

    public JSONObject fetchNews(String url){
        HttpResponse<JsonNode> httpResponse = Unirest.get(url)
                .asJson();

        return httpResponse.getBody().getObject();
    }
}

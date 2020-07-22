package org.memreyagci.searchnews.controller;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class FetchData {

    public void fetchNews(String url){
        HttpResponse<JsonNode> httpResponse = Unirest.get(url)
                .asJson();

        String result = httpResponse.getBody().toPrettyString();
    }
}

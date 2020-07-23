package org.memreyagci.searchnews.newsapi;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class NewsApiCall {

    public JSONObject fetchNews(String url){
        HttpResponse<JsonNode> httpResponse = Unirest.get(url)
                .asJson();

        return httpResponse.getBody().getObject();
    }
}

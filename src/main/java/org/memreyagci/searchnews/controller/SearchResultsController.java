package org.memreyagci.searchnews.controller;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class SearchResultsController {

    private JSONObject results;
    private JSONArray articles;

    public void setResults(JSONObject results) {
        this.results = results;
    }
}

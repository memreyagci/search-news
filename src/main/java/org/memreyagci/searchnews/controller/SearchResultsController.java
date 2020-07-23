package org.memreyagci.searchnews.controller;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.memreyagci.searchnews.model.SearchResults;

public class SearchResultsController {
    private SearchResults searchResults;

    private JSONObject results;
    private JSONArray articles;

    public void setResults(JSONObject results) {
        this.results = results;
    }

    public JSONObject getResults() {
        return results;
    }
}

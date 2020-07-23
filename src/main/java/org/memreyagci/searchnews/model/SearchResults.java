package org.memreyagci.searchnews.model;

/*
A model for defining the data of the search results to be shown in ResultsPanel.
 */

public class SearchResults {
    private String title;
    private String source;
    private String date;
    private String url;

    public SearchResults(String title, String source, String date) {
        this.title = title;
        this.source = source;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

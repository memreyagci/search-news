package org.memreyagci.searchnews;

import java.util.ArrayList;

public class NewsApiModel {
    private final String keywords = "q+";
    private final String dateFrom = "from=";
    private final String dateTo = "to=";
    private final String sortBy = "sortBY=";
    private final String domains = "domains=";
    private final String languages = "language=";

    private String providedKeyword;
    private String providedDateFrom;
    private String providedDateTo;
    private String providedSortBy;
    private String providedDomain;
    private String providedLanguage;

    private String sortByOptions;
    private boolean titleOnly;

    // Options: "relevancy", "popularity", "publishedAt". Default is: "relevancy"
    public void setSortByOptions(String sortByOptions) {
        this.sortByOptions = sortByOptions;
    }

    public String getProvidedKeyword() {
        return providedKeyword;
    }

    public void setProvidedKeyword(String providedKeyword) {
        this.providedKeyword = providedKeyword;
    }

    public String getProvidedDateFrom() {
        return providedDateFrom;
    }

    public void setProvidedDateFrom(String providedDateFrom) {
        this.providedDateFrom = providedDateFrom;
    }

    public String getProvidedDateTo() {
        return providedDateTo;
    }

    public void setProvidedDateTo(String providedDateTo) {
        this.providedDateTo = providedDateTo;
    }

    public String getProvidedSortBy() {
        return providedSortBy;
    }

    public void setProvidedSortBy(String providedSortBy) {
        this.providedSortBy = providedSortBy;
    }

    public String getProvidedDomain() {
        return providedDomain;
    }

    public void setProvidedDomain(String providedDomain) {
        this.providedDomain = providedDomain;
    }

    public String getProvidedLanguage() {
        return providedLanguage;
    }

    public void setProvidedLanguage(String providedLanguage) {
        this.providedLanguage = providedLanguage;
    }

    public boolean isTitleOnly() {
        return titleOnly;
    }

    public void setTitleOnly(boolean titleOnly) {
        this.titleOnly = titleOnly;
    }
}


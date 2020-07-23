package org.memreyagci.searchnews.controller;

import kong.unirest.json.JSONArray;
import org.memreyagci.searchnews.model.NewsApi;
import org.memreyagci.searchnews.model.SearchResults;
import org.memreyagci.searchnews.view.ResultsPanel;
import org.memreyagci.searchnews.view.SearchPanel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsApiController {
    private SearchPanel searchPanel;
    private ResultsPanel resultsPanel;

    private SearchResultsController searchResultsController;

    private NewsApi newsApi;
    private SearchResults searchResults;

    private FetchData fetchData = new FetchData();
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public NewsApiController(SearchPanel searchPanel, ResultsPanel resultsPanel, NewsApi newsApi, SearchResults searchResults, SearchResultsController searchResultsController) {
        this.searchPanel = searchPanel;
        this.resultsPanel = resultsPanel;
        this.newsApi = newsApi;
        this.searchResults = searchResults;
        this.searchResultsController = searchResultsController;
    }

    public void initController() {
        searchPanel.getSearchButton().addActionListener(e -> {
            saveNewsApi(); //Saving the model
            GenerateUrl generateUrl = new GenerateUrl();

            // Setting the fetched JSONObject to SearchResultController.results
            searchResultsController.setResults(fetchData.fetchNews(generateUrl.getUrl(newsApi)));

            createRendererModel();
        });
    }

    private void saveNewsApi() {
        Date selectedFromDate = (Date) searchPanel.getDatesFromJDatePanelImpl().getModel().getValue();
        Date selectedToDate = (Date) searchPanel.getDatesFromJDatePanelImpl().getModel().getValue();

        newsApi.setProvidedKeyword(searchPanel.getKeywordsTextField().getText());
        newsApi.setProvidedTitle(searchPanel.getTitleTextField().getText());
        newsApi.setProvidedDomain(searchPanel.getDomainsTextField().getText());
        newsApi.setProvidedDateFrom(simpleDateFormat.format(selectedFromDate));
        newsApi.setProvidedDateTo(simpleDateFormat.format(selectedToDate));
        newsApi.setProvidedSortBy(searchPanel.getSelectedRadioButtonText(searchPanel.getRadioButtonGroup()));
    }

    private void createRendererModel() {
        JSONArray articles = searchResultsController.getResults().getJSONArray("articles");

        for(int i=0; i<articles.length(); i++) {
            searchResults.setTitle(articles.getJSONObject(i).getString("title"));
            searchResults.setSource(articles.getJSONObject(i).getJSONObject("source").getString("name"));
            searchResults.setDate(articles.getJSONObject(i).getString("publishedAt"));

            resultsPanel.getDefaultListModel().addElement(searchResults);
        }
    }
}

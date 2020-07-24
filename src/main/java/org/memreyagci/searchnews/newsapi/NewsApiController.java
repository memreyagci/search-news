package org.memreyagci.searchnews.newsapi;

import kong.unirest.json.JSONArray;
import org.memreyagci.searchnews.controller.SearchResultsController;
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

    private NewsApiCall newsApiCall = new NewsApiCall();

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
            // Removing all elements from ResultsPanel.DefaultListModel to prevent adding a new search's results to the bottom of the old one(s).
            resultsPanel.getDefaultListModel().removeAllElements();

            saveNewsApi(); //Saving the model
            NewsApiUrl newsApiUrl = new NewsApiUrl();

            // Setting the fetched JSONObject to SearchResultController.results
            searchResultsController.setResults(newsApiCall.fetchNews(newsApiUrl.getUrl(newsApi)));

            createRendererModel();
            resultsPanel.createResultsList();
        });

        resultsPanel.getSearchResultsJList().addListSelectionListener(e -> {

            // Ensures that this will only run when on the final event on the chain, which is mouseUp. Thus, prevents it from running also for other events.
            if (e.getValueIsAdjusting()) {
                // TODO: Create necessary functions to display a dialog that asks user whether he wants to open the link in the browser.
            }

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
            SearchResults searchResults = new SearchResults();
            searchResults.setTitle(articles.getJSONObject(i).getString("title"));
            searchResults.setSource(articles.getJSONObject(i).getJSONObject("source").getString("name"));
            searchResults.setDate(articles.getJSONObject(i).getString("publishedAt"));
            searchResults.setUrl(articles.getJSONObject(i).getString("url"));

            resultsPanel.getDefaultListModel().addElement(searchResults);
        }
    }
}

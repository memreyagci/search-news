package org.memreyagci.searchnews.newsapi;

import kong.unirest.json.JSONArray;
import org.memreyagci.searchnews.controller.SearchResultsController;
import org.memreyagci.searchnews.model.SearchResults;
import org.memreyagci.searchnews.view.MainFrame;
import org.memreyagci.searchnews.view.ResultsPanel;
import org.memreyagci.searchnews.view.SearchPanel;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsApiController {

    private SearchPanel searchPanel;
    private ResultsPanel resultsPanel;
    private MainFrame mainFrame;

    private SearchResultsController searchResultsController;

    private NewsApi newsApi;
    private SearchResults searchResults;

    private NewsApiCall newsApiCall = new NewsApiCall();

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public NewsApiController(MainFrame mainFrame, SearchPanel searchPanel, ResultsPanel resultsPanel, NewsApi newsApi, SearchResults searchResults, SearchResultsController searchResultsController) {
        this.mainFrame = mainFrame;
        this.searchPanel = searchPanel;
        this.resultsPanel = resultsPanel;
        this.newsApi = newsApi;
        this.searchResults = searchResults;
        this.searchResultsController = searchResultsController;
    }

    // Initializes the listeners.
    public void initController() {
        searchPanel.getSearchButton().addActionListener(e -> {
            makeApiCall().execute();
        });
    }

    /*
     * This method is run when the search button is clicked.
     * It gets the user input, makes the api call, and updates the ResultPanel
     */
    public SwingWorker makeApiCall() {
        SwingWorker<Void, Void> apiCallWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                // Showing a "LOADING.." text on the right of the screen.
                SwingUtilities.invokeLater(() -> mainFrame.initializeLoadingPanel());

                // Removing all elements from ResultsPanel.DefaultListModel to prevent adding a new search's results to the bottom of the old one(s).
                resultsPanel.getDefaultListModel().removeAllElements();

                saveNewsApi(); // Getting user input and saving it to NewsApi model.

                // Setting the fetched JSONObject to SearchResultController.results
                searchResultsController.setResults(newsApiCall.fetchNews(NewsApiUrl.getUrl(newsApi)));

                return null;
            }

            @Override
            protected void done() {
                // Displays news results in ResultsPanel.
                createRendererModel();
                resultsPanel.createResultsList();

                // Showing the results on the right of the screen.
                SwingUtilities.invokeLater(() -> mainFrame.initializeResultsPanel());
            }
        };

        return apiCallWorker;
    }

    // Setting user input to NewsApi model.
    // TODO: Add the languages field.
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

    // Adding fetched news to ResultsPanel.defaultListModel.
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
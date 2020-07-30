package org.memreyagci.searchnews;

import org.memreyagci.searchnews.newsapi.NewsApiController;
import org.memreyagci.searchnews.controller.SearchResultsController;
import org.memreyagci.searchnews.newsapi.NewsApi;
import org.memreyagci.searchnews.model.SearchResults;
import org.memreyagci.searchnews.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        // View
        MainFrame mainFrame = new MainFrame();

        // Model
        NewsApi newsApi = new NewsApi();
        SearchResults searchResults = new SearchResults();

        //Controller
        SearchResultsController searchResultsController = new SearchResultsController();
        NewsApiController newsApiController = new NewsApiController(mainFrame.getSearchPanel(), mainFrame.getResultsPanel(), newsApi, searchResults, searchResultsController);
        newsApiController.initController();
    }
}

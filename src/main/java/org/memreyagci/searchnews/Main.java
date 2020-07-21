package org.memreyagci.searchnews;

import org.memreyagci.searchnews.controller.NewsApiController;
import org.memreyagci.searchnews.model.NewsApi;
import org.memreyagci.searchnews.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        // View
        MainFrame mainFrame = new MainFrame("Search News");

        // Model
        NewsApi newsApi = new NewsApi();

        //Controller
        NewsApiController newsApiController = new NewsApiController(mainFrame.getSearchPanel(), newsApi);
        newsApiController.initController();
    }
}

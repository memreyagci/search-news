package org.memreyagci.searchnews;

import org.memreyagci.searchnews.controller.SearchPanelController;
import org.memreyagci.searchnews.model.NewsApi;
import org.memreyagci.searchnews.view.MainFrame;

public class Main {

    public static void main(String[] args) {
        // View
        MainFrame mainFrame = new MainFrame("Search News");

        // Model
        NewsApi newsApi = new NewsApi();

        //Controller
        SearchPanelController searchPanelController = new SearchPanelController(mainFrame.getSearchPanel(), newsApi);
        searchPanelController.initController();
    }
}

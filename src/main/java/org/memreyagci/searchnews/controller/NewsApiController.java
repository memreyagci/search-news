package org.memreyagci.searchnews.controller;

import org.memreyagci.searchnews.model.NewsApi;
import org.memreyagci.searchnews.view.SearchPanel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchPanelController {
    private SearchPanel searchPanel;
    private NewsApi newsApi;
    private FetchData fetchData = new FetchData();
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public SearchPanelController(SearchPanel searchPanel, NewsApi newsApi) {
        this.searchPanel = searchPanel;
        this.newsApi = newsApi;
    }

    public void initController() {
        searchPanel.getSearchButton().addActionListener(e -> {
            System.out.println("Clicked!");
            saveNewsApi(); //Saving the model
            GenerateUrl generateUrl = new GenerateUrl();
            fetchData.fetchNews(generateUrl.getUrl(newsApi));
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
}

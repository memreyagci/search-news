package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;

/*
Shows user the search results, each of which is rendered by ResultRenderer.
 */

public class ResultsPanel extends JPanel {
    private JList<SearchResults> searchResultsJList;
    private DefaultListModel<SearchResults> defaultListModel = new DefaultListModel<>();

    private JList<SearchResults> createResultsList() {
        searchResultsJList = new JList<SearchResults>(defaultListModel);
        searchResultsJList.setCellRenderer(new ResultRenderer());

        return searchResultsJList;
    }

    public DefaultListModel<SearchResults> getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel<SearchResults> defaultListModel) {
        this.defaultListModel = defaultListModel;
    }
}

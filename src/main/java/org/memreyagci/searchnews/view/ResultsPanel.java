package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;

/*
Shows user the search results, each of which is rendered by ResultRenderer.
 */

public class ResultsPanel extends JPanel {
    private JList<SearchResults> searchResultsJList;
    private DefaultListModel<SearchResults> defaultListModel = new DefaultListModel<>();

    public ResultsPanel() {
        createResultsList();
    }

    public void createResultsList() {
        searchResultsJList = new JList<>(defaultListModel);
        searchResultsJList.setCellRenderer(new ResultRenderer());
    }

    public JList<SearchResults> getSearchResultsJList() {
        return searchResultsJList;
    }

    public DefaultListModel<SearchResults> getDefaultListModel() {
        return defaultListModel;
    }
}
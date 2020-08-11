package org.memreyagci.searchnews.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Initializing JPanels
    SearchPanel searchPanel = new SearchPanel();
    ResultsPanel resultsPanel = new ResultsPanel();
    LoadingPanel loadingPanel = new LoadingPanel();

    JSplitPane jSplitPane;

    public MainFrame() throws HeadlessException {

        SwingUtilities.invokeLater(() -> {
            setTitle("Search News");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1300,650);
            setLocationRelativeTo(null);

            // Adding JPanels to JSplitPane
            jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchPanel, new JScrollPane(resultsPanel.getSearchResultsJList()));
            jSplitPane.setEnabled(false);
            add(jSplitPane);

            setVisible(true);
        });
    }

    public void initializeLoadingPanel() {
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchPanel, loadingPanel);
    }

    public void initializeResultsPanel() {
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchPanel, new JScrollPane(resultsPanel.getSearchResultsJList()));
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}

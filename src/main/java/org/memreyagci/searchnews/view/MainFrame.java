package org.memreyagci.searchnews.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Initializing JPanels
    SearchPanel searchPanel = new SearchPanel();
    ResultsPanel resultsPanel = new ResultsPanel();

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
            this.add(jSplitPane);

            setVisible(true);
        });
    }

    // Shows a "LOADING..." label on the right of the screen when the search button is clicked.
    public void initializeLoadingPanel() {
            jSplitPane.setRightComponent(new LoadingPanel());
    }

    // Shows the results on the left when they are obtained.
    public void initializeResultsPanel() {
            jSplitPane.setRightComponent(new JScrollPane(resultsPanel.getSearchResultsJList()));
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}

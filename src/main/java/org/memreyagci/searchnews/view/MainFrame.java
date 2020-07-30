package org.memreyagci.searchnews.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Initializing JPanels
    SearchPanel searchPanel = new SearchPanel();
    ResultsPanel resultsPanel = new ResultsPanel();

    public MainFrame() throws HeadlessException {

        SwingUtilities.invokeLater(() -> {
            setTitle("Search News");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1300,650);
            setLocationRelativeTo(null);

            // Adding JPanels to JSplitPane
            JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchPanel, new JScrollPane(resultsPanel.getSearchResultsJList()));
            jSplitPane.setEnabled(false);
            add(jSplitPane);

            setVisible(true);
        });
    }

    public SearchPanel getSearchPanel() {
        return searchPanel;
    }

    public ResultsPanel getResultsPanel() {
        return resultsPanel;
    }
}

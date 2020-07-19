package org.memreyagci.searchnews.UserInterface;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    // Initializing JPanels
    SearchPanel searchPanel = new SearchPanel();
    ResultsPanel resultsPanel = new ResultsPanel();

    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,650);
        this.setLocationRelativeTo(null);

        // Adding JPanels to JSplitPane
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.add(searchPanel);
        jSplitPane.add(resultsPanel);
        jSplitPane.setEnabled(false);

        this.add(jSplitPane);

        this.setVisible(true);
    }

}

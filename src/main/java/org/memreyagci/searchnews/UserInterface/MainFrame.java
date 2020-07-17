package org.memreyagci.searchnews.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    SearchPanel searchPanel = new SearchPanel();
    ResultsPanel resultsPanel = new ResultsPanel();

    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.add(searchPanel);
        jSplitPane.add(resultsPanel);

        this.add(jSplitPane);

        this.setVisible(true);
    }

}

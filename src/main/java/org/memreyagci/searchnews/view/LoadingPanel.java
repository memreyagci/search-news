package org.memreyagci.searchnews.view;

/*
This JPanel is initialized in the place of ResultsPanel when the search button is clicked.
 */

import javax.swing.*;

public class LoadingPanel extends JPanel {
    public LoadingPanel() {
        this.add(new JLabel("LOADING.."));
    }
}

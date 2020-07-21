package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;
import java.awt.*;

// Result renderer.

public class ResultsPanel extends JPanel implements ListCellRenderer<SearchResults> {

    private JLabel title = new JLabel();
    private JLabel source = new JLabel();
    private JLabel date = new JLabel();

    public ResultsPanel() {

        JPanel newsPanel = new JPanel();
        newsPanel.add(title);
        newsPanel.add(source);
        newsPanel.add(date);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SearchResults> list, SearchResults searchResults, int index, boolean isSelected, boolean cellHasFocus) {
        title.setText(searchResults.getTitle());
        source.setText(searchResults.getSource());
        date.setText(searchResults.getSource());

        return this;
    }
}

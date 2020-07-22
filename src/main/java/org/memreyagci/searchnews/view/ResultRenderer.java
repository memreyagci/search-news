package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;
import java.awt.*;

/*
A cell renderer for JList whose identifier is SearchResults model.
Every JPanel created by this subclass represents one result.
 */

public class ResultRenderer extends JPanel implements ListCellRenderer<SearchResults> {

    private JLabel title = new JLabel();
    private JLabel source = new JLabel();
    private JLabel date = new JLabel();

    public ResultRenderer() {
        this.add(title);
        this.add(source);
        this.add(date);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SearchResults> list, SearchResults searchResults, int index, boolean isSelected, boolean cellHasFocus) {
        title.setText(searchResults.getTitle());
        source.setText(searchResults.getSource());
        date.setText(searchResults.getDate());

        return this;
    }
}

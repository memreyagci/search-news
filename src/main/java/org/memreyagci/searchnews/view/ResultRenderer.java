package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        this.setLayout(new BorderLayout());
        setLabelFonts();
        this.add(title, BorderLayout.NORTH);
        this.add(source, BorderLayout.CENTER);
        this.add(date, BorderLayout.SOUTH);

        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void setLabelFonts() {
        title.setFont(new Font("Courier", Font.BOLD,17));
        source.setFont(new Font("Sans Serif", Font.ITALIC, 15));
        date.setFont(new Font("Sans Serif", Font.PLAIN, 15));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends SearchResults> list, SearchResults searchResults, int index, boolean isSelected, boolean cellHasFocus) {
        title.setText(searchResults.getTitle());
        source.setText("by " + searchResults.getSource());
        date.setText("on " + searchResults.getDate());

        return this;
    }
}

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
    private String url;


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
        url = searchResults.getUrl();

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        if(isSelected) {

            /*
            TODO: For some reason, JOptionPane keeps popping up when it is run after list.clearSelection().
                Thus, I have to save index to a variable before running that function, then clear the selection,
                then create JOptionPane. Change this if you find a proper way to solve this. I will use this workaround
                for now since I have been trying to make the list selection work for about a day, and this is the best
                I could come up with.
             */
            if (!list.getValueIsAdjusting()) {
                //int selectedIndex = list.getSelectedIndex();
                list.clearSelection();

                SwingUtilities.invokeLater(() -> {
                    int input =
                            JOptionPane.showConfirmDialog(
                                new JFrame(),
                                "Do you want to open the following link in your browser?\n" + url,
                                "Open the link in the browser",
                                JOptionPane.YES_NO_OPTION
                            );

                    if(input == JOptionPane.YES_OPTION) {
                        System.out.println("successfull");
                    }
                });

            }
            this.setBackground(list.getSelectionBackground());

        } else {
            this.setBackground(list.getBackground());
        }

        return this;
    }
}
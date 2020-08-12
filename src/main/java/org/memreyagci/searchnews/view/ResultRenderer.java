package org.memreyagci.searchnews.view;

import org.memreyagci.searchnews.model.SearchResults;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

        // Things to do when of the results is clicked.
        if(isSelected) {
            if (!list.getValueIsAdjusting()) {
                list.clearSelection(); // To prevent endless repetitions of the following codes.

                /*
                Creating a JOptionPane that asks user whether they want to open the link in the browser.
                The answer is saved to input integer.
                 */
                SwingUtilities.invokeLater(() -> {
                    int input =
                            JOptionPane.showConfirmDialog(
                                new JFrame(),
                                "Do you want to open the following link in your browser?\n" + url,
                                "Open the link in the browser",
                                JOptionPane.YES_NO_OPTION
                            );

                    // If user clicks yes, open the link the browser.
                    if(input == JOptionPane.YES_OPTION) {
                        Desktop desktop = Desktop.getDesktop();
                        try {
                            desktop.browse(new URI(url));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
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
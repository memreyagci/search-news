package org.memreyagci.searchnews.UserInterface;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    JLabel keywordsLabel = new JLabel("keywords:");
    JTextField keywordsTextField = new JTextField();
    JLabel languagesLabel = new JLabel("languages:");
    JTextField languagesTextField = new JTextField();
    JLabel articleLabel = new JLabel("article");
    JTextField articleTextField = new JTextField();
    JLabel titleLabel = new JLabel("title");
    JTextField titleTextField = new JTextField();
    JLabel datesFromLabel = new JLabel("From:");
    JTextField datesFromTextField = new JTextField();
    JLabel datesToLabel = new JLabel("To:");
    JTextField datesToTextField = new JTextField();
    JLabel sourcesLabel = new JLabel("source:");
    JTextField sourcesTextField = new JTextField();
    JButton searchButton = new JButton("SEARCH");

    public SearchPanel() throws HeadlessException {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        InitializeComponents();
    }

    public void InitializeComponents() {
        this.add(keywordsLabel);
        this.add(keywordsTextField);
        this.add(languagesLabel);
        this.add(languagesTextField);
        this.add(articleLabel);
        this.add(articleTextField);
        this.add(titleLabel);
        this.add(titleTextField);
        this.add(datesFromLabel);
        this.add(datesFromTextField);
        this.add(datesToLabel);
        this.add(datesToTextField);
        this.add(sourcesLabel);
        this.add(sourcesTextField);
        this.add(searchButton);
    }


}

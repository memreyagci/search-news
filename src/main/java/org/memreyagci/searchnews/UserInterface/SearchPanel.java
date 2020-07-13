package org.memreyagci.searchnews.UserInterface;

import org.memreyagci.searchnews.FetchData;
import org.memreyagci.searchnews.NewsApiModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchPanel extends JPanel {
    NewsApiModel newsApiModel = new NewsApiModel();
    FetchData fetchData = new FetchData();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");

    // TODO: Search about setLabelFor method.
    JLabel keywordsLabel = new JLabel("keywords:");
    JTextField keywordsTextField = new JTextField();
    JLabel languagesLabel = new JLabel("languages:");
    JTextField languagesTextField = new JTextField();
//    JLabel articleLabel = new JLabel("article");
//    JTextField articleTextField = new JTextField();
    JLabel titleLabel = new JLabel("title");
    JTextField titleTextField = new JTextField();
    JLabel datesFromLabel = new JLabel("From:");
    JFormattedTextField datesFromTextField = new JFormattedTextField(dateFormat);
    JLabel datesToLabel = new JLabel("To:");
    JFormattedTextField datesToTextField = new JFormattedTextField(dateFormat);
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
//        this.add(articleLabel);
//        this.add(articleTextField);
        this.add(sourcesLabel);
        this.add(sourcesTextField);
        this.add(languagesLabel);
        this.add(languagesTextField);
        this.add(titleLabel);
        this.add(titleTextField);
        this.add(datesFromLabel);
        this.add(datesFromTextField);
        this.add(datesToLabel);
        this.add(datesToTextField);
        this.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //newsApiModel.setProvidedKeyword(getTextFieldValues());
                setNewsApiModel();
                // TODO: fetchData.fetchNews(newsApiModel);
                fetchData.FetchNews(newsApiModel);
                //fetchData.Deneme();
            }
        });
    }

    public void setNewsApiModel() {
        newsApiModel.setProvidedKeyword(keywordsTextField.getText());
        newsApiModel.setProvidedDateFrom(datesFromTextField.getText());
        newsApiModel.setProvidedDateTo(datesToTextField.getText());
        //newsApiModel.setProvidedDomain();
    }

    public String getTextFieldValues() {
        return keywordsTextField.getText();
    }

//    void OnClickSearchButton(ActionListener actionListener) {
//        searchButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //newsApiModel.setProvidedKeyword(getTextFieldValues());
//                setNewsApiModel();
//                // TODO: fetchData.fetchNews(newsApiModel);
//                fetchData.FetchNews(newsApiModel);
//            }
//        });
    }


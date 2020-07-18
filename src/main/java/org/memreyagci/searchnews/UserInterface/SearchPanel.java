package org.memreyagci.searchnews.UserInterface;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import org.memreyagci.searchnews.FetchData;
import org.memreyagci.searchnews.NewsApiModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchPanel extends JPanel {
    NewsApiModel newsApiModel = new NewsApiModel();
    FetchData fetchData = new FetchData();
    GridBagConstraints gbc = new GridBagConstraints();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // TODO: Search about setLabelFor method.
    JLabel keywordsLabel = new JLabel("keywords:");
    JTextField keywordsTextField = new JTextField();

    JLabel languagesLabel = new JLabel("languages:");
    JTextField languagesTextField = new JTextField();

    JLabel titleLabel = new JLabel("title");
    JTextField titleTextField = new JTextField();

    JLabel datesFromLabel = new JLabel("From:");
    JDatePanelImpl datesFromJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
    JDatePickerImpl datesFromJDatePickerImpl = new JDatePickerImpl(datesFromJDatePanelImpl);

    JLabel datesToLabel = new JLabel("To:");
    JDatePanelImpl datesToJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
    JDatePickerImpl datesToDatePicker = new JDatePickerImpl(datesToJDatePanelImpl);

    JLabel sourcesLabel = new JLabel("source:");
    JTextField sourcesTextField = new JTextField();

    JButton searchButton = new JButton("SEARCH");

    public SearchPanel() throws HeadlessException {
        this.setLayout(new GridBagLayout());
        InitializeComponents();
        SetOnClickListeners();
    }

    public void InitializeComponents() {
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(keywordsLabel, gbc);
        gbc.gridy++;
        this.add(sourcesLabel, gbc);
        gbc.gridy++;
        this.add(languagesLabel, gbc);
        gbc.gridy++;
        this.add(titleLabel, gbc);
        gbc.gridy++;
        this.add(datesFromLabel, gbc);
        gbc.gridy++;
        this.add(datesToLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(keywordsTextField, gbc);
        gbc.gridy++;
        this.add(sourcesTextField, gbc);
        gbc.gridy++;
        this.add(languagesTextField, gbc);
        gbc.gridy++;
        this.add(titleTextField, gbc);
        gbc.gridy++;
        this.add(datesFromJDatePickerImpl, gbc);
        gbc.gridy++;
        this.add(datesToDatePicker, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(searchButton, gbc);
    }

    // Sets onClickListeners
    public void SetOnClickListeners() {
        searchButton.addActionListener(e -> {
            //newsApiModel.setProvidedKeyword(getTextFieldValues());
            setNewsApiModel();
            // TODO: fetchData.fetchNews(newsApiModel);
            fetchData.FetchNews(newsApiModel);
        });
    }

    // Sets NewsApiModel variables
    // Being used in FetchNews.fetchData
    public void setNewsApiModel() {
        Date selectedFromDate = (Date) datesFromJDatePickerImpl.getModel().getValue();
        Date selectedToDate = (Date) datesFromJDatePickerImpl.getModel().getValue();

        newsApiModel.setProvidedKeyword(keywordsTextField.getText());
        newsApiModel.setProvidedDateFrom(simpleDateFormat.format(selectedFromDate));
        newsApiModel.setProvidedDateTo(simpleDateFormat.format(selectedToDate));
    }

    public String getTextFieldValues() {
        return keywordsTextField.getText();
    }

    }


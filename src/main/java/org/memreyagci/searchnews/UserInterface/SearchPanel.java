package org.memreyagci.searchnews.UserInterface;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import org.memreyagci.searchnews.FetchData;
import org.memreyagci.searchnews.NewsApiModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class SearchPanel extends JPanel {
    NewsApiModel newsApiModel = new NewsApiModel();
    FetchData fetchData = new FetchData();
    GridBagConstraints gbc = new GridBagConstraints();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Components of the SearchPanel
    JLabel keywordsLabel = new JLabel("Keywords:");
    JTextField keywordsTextField = new JTextField();

    JLabel titleLabel = new JLabel("Title");
    JTextField titleTextField = new JTextField();

    JLabel domainsLabel = new JLabel("Domains:");
    JTextField domainsTextField = new JTextField();

    JLabel languagesLabel = new JLabel("Languages:");
    JTextField languagesTextField = new JTextField();

    JLabel datesFromLabel = new JLabel("From the date of:");
    JDatePanelImpl datesFromJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
    JDatePickerImpl datesFromJDatePickerImpl = new JDatePickerImpl(datesFromJDatePanelImpl);

    JLabel datesToLabel = new JLabel("To the date of:");
    JDatePanelImpl datesToJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
    JDatePickerImpl datesToDatePicker = new JDatePickerImpl(datesToJDatePanelImpl);

    JLabel sortByLabel = new JLabel("Sort by:");
    JPanel radioButtonJPanel = new JPanel();
    ButtonGroup radioButtonGroup = new ButtonGroup();
    JRadioButton sortByRelevancyRadioButton = new JRadioButton("relevancy");
    JRadioButton sortByPopularityRadioButton = new JRadioButton("popularity");
    JRadioButton sortByPublishDateRadioButton = new JRadioButton("publish date");

    JButton searchButton = new JButton("SEARCH");

    public SearchPanel() throws HeadlessException {
        this.setLayout(new GridBagLayout());
        InitializeComponents();
        SetActionListeners();
    }

    // Adding components to the layout and setting their places.
    public void InitializeComponents() {
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(keywordsLabel, gbc);
        gbc.gridy++;
        this.add(titleLabel, gbc);
        gbc.gridy++;
        this.add(domainsLabel, gbc);
        gbc.gridy++;
        this.add(datesFromLabel, gbc);
        gbc.gridy++;
        this.add(datesToLabel, gbc);
        gbc.gridy++;
        this.add(languagesLabel, gbc);
        gbc.gridy++;
        this.add(sortByLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(keywordsTextField, gbc);
        gbc.gridy++;
        this.add(titleTextField, gbc);
        gbc.gridy++;
        this.add(domainsTextField, gbc);
        gbc.gridy++;
        this.add(datesFromJDatePickerImpl, gbc);
        gbc.gridy++;
        this.add(datesToDatePicker, gbc);
        gbc.gridy++;
        this.add(languagesTextField, gbc);

        radioButtonGroup.add(sortByRelevancyRadioButton);
        radioButtonGroup.add(sortByPopularityRadioButton);
        radioButtonGroup.add(sortByPublishDateRadioButton);
        radioButtonJPanel.add(sortByRelevancyRadioButton);
        radioButtonJPanel.add(sortByPopularityRadioButton);
        radioButtonJPanel.add(sortByPublishDateRadioButton);
        sortByRelevancyRadioButton.setSelected(true);

        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridy++;
        this.add(radioButtonJPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(searchButton, gbc);
    }

    // Source: https://rendicahya.wordpress.com
    String getSelectedRadioButtonText(ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    // Sets ActionListeners
    public void SetActionListeners() {
        searchButton.addActionListener(e -> {
            setNewsApiModel();
            fetchData.FetchNews(newsApiModel);
        });
    }

    // Sets NewsApiModel variables
    // Being used in FetchNews.fetchData
    public void setNewsApiModel() {
        Date selectedFromDate = (Date) datesFromJDatePickerImpl.getModel().getValue();
        Date selectedToDate = (Date) datesFromJDatePickerImpl.getModel().getValue();

        newsApiModel.setProvidedKeyword(keywordsTextField.getText());
        newsApiModel.setProvidedTitle(titleTextField.getText());
        newsApiModel.setProvidedDomain(domainsTextField.getText());
        newsApiModel.setProvidedDateFrom(simpleDateFormat.format(selectedFromDate));
        newsApiModel.setProvidedDateTo(simpleDateFormat.format(selectedToDate));
        newsApiModel.setProvidedSortBy(getSelectedRadioButtonText(radioButtonGroup));
    }
}


package org.memreyagci.searchnews.UserInterface;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

public class SearchPanel extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // Components of the SearchPanel
    JLabel keywordsLabel;
    JTextField keywordsTextField;

    JLabel titleLabel;
    JTextField titleTextField;

    JLabel domainsLabel;
    JTextField domainsTextField;

    JLabel languagesLabel;
    JTextField languagesTextField;

    JLabel datesFromLabel;
    JDatePanelImpl datesFromJDatePanelImpl;
    JDatePickerImpl datesFromJDatePickerImpl;

    JLabel datesToLabel;
    JDatePanelImpl datesToJDatePanelImpl;
    JDatePickerImpl datesToDatePicker;

    JLabel sortByLabel;
    JPanel radioButtonJPanel;
    ButtonGroup radioButtonGroup;
    JRadioButton sortByRelevancyRadioButton;
    JRadioButton sortByPopularityRadioButton;
    JRadioButton sortByPublishDateRadioButton;

    JButton searchButton;

    public SearchPanel(){

        // Initialize the components
        keywordsLabel = new JLabel("Keywords:");
        keywordsTextField = new JTextField();

        titleLabel = new JLabel("Title");
        titleTextField = new JTextField();

        domainsLabel = new JLabel("Domains:");
        domainsTextField = new JTextField();

        languagesLabel = new JLabel("Languages:");
        languagesTextField = new JTextField();

        datesFromLabel = new JLabel("From the date of:");
        datesFromJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
        datesFromJDatePickerImpl = new JDatePickerImpl(datesFromJDatePanelImpl);

        datesToLabel = new JLabel("To the date of:");
        datesToJDatePanelImpl = new JDatePanelImpl(new UtilDateModel());
        datesToDatePicker = new JDatePickerImpl(datesToJDatePanelImpl);

        sortByLabel = new JLabel("Sort by:");
        radioButtonJPanel = new JPanel();
        radioButtonGroup = new ButtonGroup();
        sortByRelevancyRadioButton = new JRadioButton("relevancy");
        sortByPopularityRadioButton = new JRadioButton("popularity");
        sortByPublishDateRadioButton = new JRadioButton("publish date");

        searchButton = new JButton("SEARCH");

        this.setLayout(new GridBagLayout());
    }

    public JLabel getKeywordsLabel() {
        return keywordsLabel;
    }

    public void setKeywordsLabel(JLabel keywordsLabel) {
        this.keywordsLabel = keywordsLabel;
    }

    public JTextField getKeywordsTextField() {
        return keywordsTextField;
    }

    public void setKeywordsTextField(JTextField keywordsTextField) {
        this.keywordsTextField = keywordsTextField;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(JTextField titleTextField) {
        this.titleTextField = titleTextField;
    }

    public JLabel getDomainsLabel() {
        return domainsLabel;
    }

    public void setDomainsLabel(JLabel domainsLabel) {
        this.domainsLabel = domainsLabel;
    }

    public JTextField getDomainsTextField() {
        return domainsTextField;
    }

    public void setDomainsTextField(JTextField domainsTextField) {
        this.domainsTextField = domainsTextField;
    }

    public JLabel getLanguagesLabel() {
        return languagesLabel;
    }

    public void setLanguagesLabel(JLabel languagesLabel) {
        this.languagesLabel = languagesLabel;
    }

    public JTextField getLanguagesTextField() {
        return languagesTextField;
    }

    public void setLanguagesTextField(JTextField languagesTextField) {
        this.languagesTextField = languagesTextField;
    }

    public JLabel getDatesFromLabel() {
        return datesFromLabel;
    }

    public void setDatesFromLabel(JLabel datesFromLabel) {
        this.datesFromLabel = datesFromLabel;
    }

    public JDatePanelImpl getDatesFromJDatePanelImpl() {
        return datesFromJDatePanelImpl;
    }

    public void setDatesFromJDatePanelImpl(JDatePanelImpl datesFromJDatePanelImpl) {
        this.datesFromJDatePanelImpl = datesFromJDatePanelImpl;
    }

    public JDatePickerImpl getDatesFromJDatePickerImpl() {
        return datesFromJDatePickerImpl;
    }

    public void setDatesFromJDatePickerImpl(JDatePickerImpl datesFromJDatePickerImpl) {
        this.datesFromJDatePickerImpl = datesFromJDatePickerImpl;
    }

    public JLabel getDatesToLabel() {
        return datesToLabel;
    }

    public void setDatesToLabel(JLabel datesToLabel) {
        this.datesToLabel = datesToLabel;
    }

    public JDatePanelImpl getDatesToJDatePanelImpl() {
        return datesToJDatePanelImpl;
    }

    public void setDatesToJDatePanelImpl(JDatePanelImpl datesToJDatePanelImpl) {
        this.datesToJDatePanelImpl = datesToJDatePanelImpl;
    }

    public JDatePickerImpl getDatesToDatePicker() {
        return datesToDatePicker;
    }

    public void setDatesToDatePicker(JDatePickerImpl datesToDatePicker) {
        this.datesToDatePicker = datesToDatePicker;
    }

    public JLabel getSortByLabel() {
        return sortByLabel;
    }

    public void setSortByLabel(JLabel sortByLabel) {
        this.sortByLabel = sortByLabel;
    }

    public JPanel getRadioButtonJPanel() {
        return radioButtonJPanel;
    }

    public void setRadioButtonJPanel(JPanel radioButtonJPanel) {
        this.radioButtonJPanel = radioButtonJPanel;
    }

    public ButtonGroup getRadioButtonGroup() {
        return radioButtonGroup;
    }

    public void setRadioButtonGroup(ButtonGroup radioButtonGroup) {
        this.radioButtonGroup = radioButtonGroup;
    }

    public JRadioButton getSortByRelevancyRadioButton() {
        return sortByRelevancyRadioButton;
    }

    public void setSortByRelevancyRadioButton(JRadioButton sortByRelevancyRadioButton) {
        this.sortByRelevancyRadioButton = sortByRelevancyRadioButton;
    }

    public JRadioButton getSortByPopularityRadioButton() {
        return sortByPopularityRadioButton;
    }

    public void setSortByPopularityRadioButton(JRadioButton sortByPopularityRadioButton) {
        this.sortByPopularityRadioButton = sortByPopularityRadioButton;
    }

    public JRadioButton getSortByPublishDateRadioButton() {
        return sortByPublishDateRadioButton;
    }

    public void setSortByPublishDateRadioButton(JRadioButton sortByPublishDateRadioButton) {
        this.sortByPublishDateRadioButton = sortByPublishDateRadioButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }

    // Adding components to the layout and setting their places.
    public void PlaceTheComponents() {
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
//
//    // Source: https://rendicahya.wordpress.com
//    String getSelectedRadioButtonText(ButtonGroup buttonGroup) {
//        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
//            AbstractButton button = (AbstractButton) buttons.nextElement();
//
//            if (button.isSelected()) {
//                return button.getText();
//            }
//        }
//        return null;
//    }
//
//    // Sets ActionListeners
//    public void SetActionListeners() {
//        searchButton.addActionListener(e -> {
//            setNewsApiModel();
//            fetchData.FetchNews(newsApiModel);
//        });
//    }
//
//    // Sets NewsApiModel variables
//    // Being used in FetchNews.fetchData
//    public void setNewsApiModel() {
//        Date selectedFromDate = (Date) datesFromJDatePickerImpl.getModel().getValue();
//        Date selectedToDate = (Date) datesFromJDatePickerImpl.getModel().getValue();
//
//        newsApiModel.setProvidedKeyword(keywordsTextField.getText());
//        newsApiModel.setProvidedTitle(titleTextField.getText());
//        newsApiModel.setProvidedDomain(domainsTextField.getText());
//        newsApiModel.setProvidedDateFrom(simpleDateFormat.format(selectedFromDate));
//        newsApiModel.setProvidedDateTo(simpleDateFormat.format(selectedToDate));
//        newsApiModel.setProvidedSortBy(getSelectedRadioButtonText(radioButtonGroup));
//    }
}


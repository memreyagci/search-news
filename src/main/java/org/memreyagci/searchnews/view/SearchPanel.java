package org.memreyagci.searchnews.view;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class SearchPanel extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();

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
        placeTheComponents();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    // Adding components to the layout and setting their places.
    public void placeTheComponents() {
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
    public String getSelectedRadioButtonText(ButtonGroup buttonGroup) {
        for (Enumeration buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = (AbstractButton) buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }


    // Getters & setters

    public JTextField getKeywordsTextField() {
        return keywordsTextField;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public JTextField getDomainsTextField() {
        return domainsTextField;
    }

    public JDatePanelImpl getDatesFromJDatePanelImpl() {
        return datesFromJDatePanelImpl;
    }

    public ButtonGroup getRadioButtonGroup() {
        return radioButtonGroup;
    }
}


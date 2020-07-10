package org.memreyagci.searchnews.UserInterface;

import com.google.gson.annotations.JsonAdapter;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750,500);
        this.setLocationRelativeTo(null);

//        this.add(new SearchPanel());
//        this.add(new ResultsPanel());

        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jSplitPane.add(new SearchPanel());
        jSplitPane.add(new ResultsPanel());

        this.add(jSplitPane);

        this.setVisible(true);
    }
}

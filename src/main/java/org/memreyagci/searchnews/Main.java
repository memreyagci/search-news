package org.memreyagci.searchnews;

import org.memreyagci.searchnews.UserInterface.MainFrame;

import javax.swing.*;

public class Main {
    JFrame mainFrame = new MainFrame("SEARCH NEWS");
    NewsApiModel newsApiModel = new NewsApiModel();
    FetchData fetchData = new FetchData();

    public Main() {
    }


    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("Search News");
    }
}

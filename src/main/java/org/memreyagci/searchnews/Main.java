package org.memreyagci.searchnews;

import org.memreyagci.searchnews.UserInterface.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        FetchData fd = new FetchData();
        System.out.println("This is the output: " + fd.Deneme());

        JFrame frame = new MainFrame("GUI Test");
    }
}

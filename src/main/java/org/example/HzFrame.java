package org.example;

import javax.swing.*;

public class HzFrame extends JFrame {
    public HzFrame(Logistics logistics){
        ThreadLogistics panel = new ThreadLogistics(logistics, this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(null);
        this.setVisible(true);

    }
}
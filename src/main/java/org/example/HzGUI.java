package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class HzGUI extends JFrame{
    // creates canvas inside itself.
    public ArrayList<ThrdObj> threadObjects = new ArrayList<>();

    public HzGUI(Logistics logistics) { //constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(null);
        this.setVisible(true);
        ThreadLogistics panel = new ThreadLogistics(logistics, this );
    }
}

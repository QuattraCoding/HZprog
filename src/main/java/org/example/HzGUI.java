package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HzGUI{

    JFrame frame = new JFrame();
    public JButton button = new JButton();

    public HzGUI() {
        button.setBounds(0,0,420,420);
        button.setFocusable(false);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

}

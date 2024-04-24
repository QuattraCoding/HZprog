package org.example;



import javax.sound.sampled.LineUnavailableException;
import java.util.List;


import java.awt.event.*;

public class HzProgram implements ActionListener{
    /*includes a list with set frequencies and includes logistics that is needed for the program to work. connects all these components to make it work. */
    List<Frequency> frequencies = List.of(new Frequency("E1", 41.2f), new Frequency("C3", 130.8f), new Frequency("G3", 196f), new Frequency("A4", 440f), new Frequency("D5", 597.33f));
    public HzProgram() throws LineUnavailableException {
        new HzGUI(new Logistics(frequencies));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}


package org.example;



import javax.sound.sampled.LineUnavailableException;
import java.util.List;


import java.awt.event.*;

public class HzProgram implements ActionListener{


    private final List<Frequency> frequencies = List.of(new Frequency("E1", 41.2f), new Frequency("C3", 130.8f), new Frequency("G3", 196f), new Frequency("A4", 440f), new Frequency("D5", 597.33f) );
    Logistics logistics = new Logistics(frequencies);
    HzGUI hzGUI;


    /* -------------------------------------------- */

    public HzProgram() throws LineUnavailableException {
        hzGUI = new HzGUI(logistics);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


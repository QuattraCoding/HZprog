package org.example;


import javax.sound.sampled.LineUnavailableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.awt.event.*;

public class HzProgram implements ActionListener{

    HzGUI hzGUI;
    private final List<Frequency> frequencies = List.of(new Frequency("E1", 41.2f), new Frequency("C3", 130.8f), new Frequency("G3", 196f), new Frequency("A4", 440f), new Frequency("D5", 597.33f) );
    HashMap<Integer, Frequency> frequencyHashMap;
    ArrayList<Sample> samples = new ArrayList<>();
    FixFrequencies fixFrequencies = new FixFrequencies(samples, frequencies, frequencyHashMap);
    RunProgram runProgram;



    /* -------------------------------------------- */


    public HzProgram(){

        hzGUI = new HzGUI();
        try {
            runProgram.InitiateTest();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


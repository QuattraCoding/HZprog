package org.example;

import org.apache.commons.lang3.time.StopWatch;


import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;



import java.awt.event.*;

public class HzProgram implements ActionListener {

    JFrame frame = new JFrame();
    public JButton button = new JButton();
    private final boolean ON = true;
    private final Random random = new Random();
    public StopWatch time = new StopWatch();
    boolean buttonClicked;
    SineWaveThread sineWaveThread = new SineWaveThread();

    /* -------------------------------------------- */

    public HzProgram(){

        button.setBounds(0,0,420,420);
        button.setFocusable(false);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

        try {
            InitiateTest();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

    }


    public void InitiateTest() throws LineUnavailableException {

        long randomisedTime = randomiseTime();

        time.start();
    do{
        if(time.getTime(TimeUnit.SECONDS) == randomisedTime) {

            sineWaveThread.start();

            //First time since start saved here
            long t1 = time.getTime(TimeUnit.MILLISECONDS);

            button.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                    buttonClicked = true;
                    sineWaveThread.sample1.buttonClicked = true;
                    sineWaveThread.interrupt();

                    }
                    });
            do {

                //If statement that shows if the string isn't empty.
                if (buttonClicked) {
                    //Second time saved here
                    time.split();
                    long t2 = time.getSplitTime();
                    System.out.println(t2 + " : t2");
                    System.out.println(t1 + " : t1");
                    System.out.println(randomisedTime + " är slumpmässigt tid");
                    long tResult = t2 - t1;
                    System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                    System.out.println("Frekvensen = " + sineWaveThread.sample1.frequency.getFrequency() + ". Tone = " + sineWaveThread.sample1.frequency.getName());

                    break;
                }


            }while(time.getTime(TimeUnit.SECONDS) >= randomisedTime);

        }
    }while(ON);

    }
    public long randomiseTime(){

        long randomisedTime = random.nextInt(11);
        return randomisedTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


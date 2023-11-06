package org.example;

import org.apache.commons.lang3.time.StopWatch;


import javax.swing.*;
import java.io.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;



import java.awt.event.*;
import javax.swing.*;

public class MyStopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton button = new JButton();


    boolean buttonClicked = false;
    private final boolean b = true;
    private final Random random = new Random();
    public StopWatch time = new StopWatch();


    public MyStopwatch(){

        button.setBounds(0,0,420,420);
        button.setFocusable(false);

        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public long randomiseTime(){

        long l = random.nextInt(11);
        return l;
    }
    public void reactionTimer(){

        long a = randomiseTime();
        time.start();
    do{
        if(time.getTime(TimeUnit.SECONDS) == a) {

            button.setText("lol click");
            //First time since start saved here
            long t1 = time.getTime(TimeUnit.MILLISECONDS);

            button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    buttonClicked = true;


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
                    System.out.println(a + " är slumpmässigt tid");
                    long tResult = t2 - t1;
                    System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                    break;
                }


            }while(time.getTime(TimeUnit.SECONDS) >= a);


        }
    }while(b);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


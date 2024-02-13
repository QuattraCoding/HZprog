package org.example.toDelete;

import org.apache.commons.lang3.time.StopWatch;
import org.example.Logistics;
import org.example.SineWaveThread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class RunTest {

    private final Random random = new Random();
    public boolean buttonClicked = false;
    private boolean randomisedTimeElapsed = true;

    StopWatch time = new StopWatch();
    SineWaveThread sineWaveThread;

    public RunTest(Logistics logistics){
        sineWaveThread = new SineWaveThread(logistics);

    }

    public void runSample(JButton jButton){

        long randomisedTime = randomiseTime();

        if(!time.isStarted()) {
            time.start();
        }
        do{
            if(time.getTime(TimeUnit.SECONDS) == randomisedTime) {

                if (!sineWaveThread.isAlive()) {
                    sineWaveThread.start();
                }

                //First time since start saved here
                long t1 = time.getTime(TimeUnit.MILLISECONDS);

                jButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        buttonClicked = true;
                        sineWaveThread.interrupt();





                    }

                });
                do {

                    time.split();
                    long t2 = time.getSplitTime();
                    long tResult = t2 - t1;
                    System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                    System.out.println(t2 + " : t2");
                    System.out.println(t1 + " : t1");
                    System.out.println(randomisedTime + " är slumpmässigt tid");
                    randomisedTimeElapsed = false;
                    buttonClicked = false;


                }while(buttonClicked);

            }
        }while(randomisedTimeElapsed);
}

    public long randomiseTime(){

        long randomisedTime = random.nextInt(11);
        return randomisedTime;
    }
}

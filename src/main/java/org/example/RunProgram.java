package org.example;

import org.apache.commons.lang3.time.StopWatch;

import javax.sound.sampled.LineUnavailableException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunProgram implements ActionListener {
    public boolean buttonClicked = false;
    private boolean randomisedTimeElapsed = true;
    private final Random random = new Random();
    public StopWatch time = new StopWatch();
    SineWaveThread sineWaveThread;
    HzGUI hzGUI;
    public RunProgram(ArrayList<Sample> samplesArrayList, HzGUI hzGUI, FixFrequencies fixFrequencies) throws LineUnavailableException {

        this.hzGUI = hzGUI;
        sineWaveThread = new SineWaveThread(samplesArrayList, fixFrequencies);
        InitiateTest();

    }

    public void InitiateTest() throws LineUnavailableException {

        long randomisedTime = randomiseTime();

        time.start();
        do{
            if(time.getTime(TimeUnit.SECONDS) == randomisedTime) {

                sineWaveThread.start();

                //First time since start saved here
                long t1 = time.getTime(TimeUnit.MILLISECONDS);



                hzGUI.button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        buttonClicked = true;
                        sineWaveThread.sample1.stopSound();
                        sineWaveThread.interrupt();


                    }
                });

                do {

                    //If statement that shows if the string isn't empty.
                    if (buttonClicked) {
                        //Second time saved here
                        time.split();
                        long t2 = time.getSplitTime();
                        long tResult = t2 - t1;
                        System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                        System.out.println(t2 + " : t2");
                        System.out.println(t1 + " : t1");
                        System.out.println(randomisedTime + " är slumpmässigt tid");

                        randomisedTimeElapsed = false;
                    }

                }while(time.getTime(TimeUnit.SECONDS) >= randomisedTime);

            }
        }while(randomisedTimeElapsed);

    }
    public long randomiseTime(){

        long randomisedTime = random.nextInt(11);
        return randomisedTime;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunTest {

    //alot of essential things to the program are here and values used to calculate milliseconds between are also here. has a method that runs the test once.
    long t1;
    long t2;
    long randomisedTime;
    private final Random random = new Random();

    public void setRandomisedTimeElapsed(boolean randomisedTimeElapsed) {
        this.randomisedTimeElapsed = randomisedTimeElapsed;
    }

    public boolean isRandomisedTimeElapsed() {
        return randomisedTimeElapsed;
    }

    private boolean randomisedTimeElapsed = true;
    final StopWatch time = new StopWatch();
    private SineWaveThread sineWaveThread;
    private final HzGUI hzGUI;
    public RunTest(Logistics logistics, HzGUI hzGUI){
        this.hzGUI = hzGUI;
        sineWaveThread = new SineWaveThread(logistics);
    }
    public void startTimer(){
        //starts test and timer
        randomisedTime = randomiseTime();
        System.out.println("Test startat");
        time.start();

    }

    public long randomiseTime(){
        randomisedTime = random.nextInt(4) + 2;
        return randomisedTime;
    }


    public SineWaveThread getSineWaveThread() {
        return sineWaveThread;
    }
}


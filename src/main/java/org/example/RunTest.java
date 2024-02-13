package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunTest {
    boolean b = false;
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
    Logistics logistics;
    StopWatch time = new StopWatch();
    SineWaveThread sineWaveThread;
    Canvas canvas;
    MouseListener action;
    public RunTest(Logistics logistics,Canvas canvas){

        this.canvas = canvas;
        sineWaveThread = new SineWaveThread(logistics);
    }
    public void startTimer(){
        randomisedTime = randomiseTime();
        System.out.println("Test startat");
        time.start();

    }

    public long randomiseTime(){
        randomisedTime = random.nextInt(11);
        return randomisedTime;
    }


}


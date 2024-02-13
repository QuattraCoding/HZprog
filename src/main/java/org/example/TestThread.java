package org.example;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestThread extends Thread{
    Canvas canvas;
    boolean mouseClicked = false;
    Logistics logistics;
    RunTest runTest;

    boolean b1 = false;
    boolean b2 = false;

    DoWhileLoop doWhileLoop;
    mouseListner mouseL;

    public TestThread (Logistics logistics, Canvas canvas, int index, HzFrame hzFrame, ArrayList<ThrdObj> threadObjects, mouseListner mouseL){
        doWhileLoop = new DoWhileLoop(logistics,this , canvas, index, hzFrame, threadObjects, mouseL);
        runTest = new RunTest(logistics, canvas);
        this.canvas = canvas;
        this.logistics = logistics;



    }


    @Override
    public void run() {
            b1 = true;

        runTest.startTimer();
        doWhileLoop.start();

        do{

            if(runTest.time.getTime(TimeUnit.SECONDS) == runTest.randomisedTime) {
                if (!runTest.sineWaveThread.isAlive()) {
                    b2 = true;
                    System.out.println("timern startad");
                    runTest.sineWaveThread.start();
                    //First time since start saved here

                    runTest.t1 = runTest.time.getTime(TimeUnit.MILLISECONDS);
                }
            }

            if(!runTest.sineWaveThread.onSwitch) {
                runTest.time.split();
                long t2 = runTest.time.getSplitTime();
                long tResult = runTest.t2 - runTest.t1;
                System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                System.out.println(t2 + " : t2");
                System.out.println(runTest.t1 + " : t1");
                System.out.println(runTest.randomisedTime + " är slumpmässigt tid");
                runTest.time.stop();
                runTest.setRandomisedTimeElapsed(false);

            }
        }while(runTest.isRandomisedTimeElapsed());

    }
}

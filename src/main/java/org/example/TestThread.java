package org.example;

import org.whispersystems.libsignal.logging.Log;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestThread extends Thread{
    //an instance of a test that gets removed from the memory after its been played
    final RunTest runTest;
    protected HzGUI hzGUI;

    Logistics logistics;

    private boolean b1 = false;
    private boolean b2 = false;

    private final DoWhileLoop doWhileLoop;

    public TestThread (Logistics logistics, Canvas canvas, int index, HzGUI hzFrame, ArrayList<ThrdObj> threadObjects, mouseListner mouseL){
        doWhileLoop = new DoWhileLoop(logistics,this , canvas, index, hzFrame, threadObjects, mouseL);
        runTest = new RunTest(logistics, hzFrame);
        this.hzGUI = hzFrame;
        this.logistics = logistics;
    }


    @Override
    public void run() {
        //the main test, prints result after.
            b1 = true;
        runTest.startTimer();
        doWhileLoop.start();

        do{
            if(runTest.time.getTime(TimeUnit.SECONDS) == runTest.randomisedTime) {
                if (!runTest.getSineWaveThread().isAlive()) {
                    b2 = true;
                    runTest.getSineWaveThread().start();
                    //First time since start saved here
                    runTest.t1 = runTest.time.getTime(TimeUnit.MILLISECONDS);
                }
            }

            if(!runTest.getSineWaveThread().onSwitch) {
                runTest.time.split();

                System.out.println();
                long t2 = runTest.time.getSplitTime();
                long tResult = runTest.t2 - runTest.t1;
                System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                System.out.println();
                System.out.println(t2 + " : t2");
                System.out.println(runTest.t1 + " : t1");
                System.out.println(runTest.randomisedTime + " är slumpmässigt tid");
                runTest.time.stop();
                runTest.setRandomisedTimeElapsed(false);


            }
        }while(runTest.isRandomisedTimeElapsed());

    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

}

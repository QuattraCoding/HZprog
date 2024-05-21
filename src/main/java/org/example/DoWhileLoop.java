package org.example;

import java.util.ArrayList;

public class DoWhileLoop extends Thread{
    //continously checks in background for mouseListeners and changes boolean values depending on it.
    private final TestThread testThread;
    private final Canvas canvas;
    private final int index;
    private final HzGUI hzFrame;
    private final ArrayList<ThrdObj> threadObjects;
    private final Logistics logistics;
    private final mouseListenerObj mouseL;
    HzGUI hzGUI;

    public DoWhileLoop(Logistics logistics, TestThread testThread, Canvas canvas, int index, HzGUI hzFrame, ArrayList<ThrdObj> threadObjects, mouseListenerObj mouseL) {
        //constructor
        this.hzGUI = hzFrame;
        this.testThread = testThread;
        this.canvas = canvas;
        this.index = index;
        this.hzFrame = hzFrame;
        this.threadObjects = threadObjects;
        this.logistics = logistics;
        this.mouseL = mouseL;
    }
    @Override
    public void run() {
        int counter= 0;

        //checks conditions while test is running.

        do {
            if(!testThread.runTest.isRandomisedTimeElapsed()){
                System.out.println("DoWhileLoop counter: " + counter);
                counter++;
                //part of the test process that makes sure you cant press the mouselistener after it has been pressed. Untill it's reinstated.
                hzFrame.remove(canvas);
                threadObjects.remove(index);
                threadObjects.add(index, new ThrdObj(logistics, hzGUI, threadObjects,index));


            }
            if (testThread.isB1()){
                canvas.removeMouseListener(mouseL);
                testThread.setB1(false);
            }
            else if(testThread.isB2()){
                canvas.addMouseListener(mouseL);
                testThread.setB2(false);
            }


        }while(testThread.isAlive() && counter<5);

    }
}

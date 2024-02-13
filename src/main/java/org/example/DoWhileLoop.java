package org.example;

import java.util.ArrayList;

public class DoWhileLoop extends Thread{
    TestThread testThread;
    Canvas canvas;
    int index;
    HzFrame hzFrame;
    ArrayList<ThrdObj> threadObjects;
    Logistics logistics;
    mouseListner mouseL;

    public DoWhileLoop(Logistics logistics, TestThread testThread, Canvas canvas, int index, HzFrame hzFrame, ArrayList<ThrdObj> threadObjects, mouseListner mouseL) {
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

        do {
            if(!testThread.runTest.isRandomisedTimeElapsed()){
                hzFrame.remove(canvas);
                threadObjects.remove(index);
                threadObjects.add(index, new ThrdObj(logistics,hzFrame,threadObjects,index));


            }
            if (testThread.b1){
                canvas.removeMouseListener(mouseL);
                testThread.b1 = false;
            }
            else if(testThread.b2){
                canvas.addMouseListener(mouseL);
                testThread.b2 = false;
            }

        }while(testThread.isAlive());



    }
}

package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ThrdObj{
    Logistics logistics;
    TestThread testThread;
    Canvas canvas;
    int index;
    HzFrame hzFrame;
    mouseListner mouseL;
    ArrayList<ThrdObj> threadObjects;

    public ThrdObj(Logistics logistics, HzFrame hzFrame,ArrayList<ThrdObj> threadObjects, int index){
        this.mouseL = new mouseListner(this);
        this.index = index;
        this.threadObjects = threadObjects;
        this.hzFrame = hzFrame;
        this.logistics = logistics;
        canvas = new Canvas();
        hzFrame.add(canvas);
        this.testThread = new TestThread(logistics, canvas, index, hzFrame, threadObjects, mouseL);
        canvas.addMouseListener(this.mouseL);


    }
    public void starter() {

        this.testThread.start();

    }
    public void stopper() {
        canvas.removeMouseListener(this.mouseL);
        this.testThread.runTest.sineWaveThread.Stop();
       // threadObjects.remove(index);
       // threadObjects.add(index, new ThrdObj(logistics,hzFrame,threadObjects,index));

    }

}

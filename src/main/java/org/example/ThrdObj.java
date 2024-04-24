package org.example;

import java.util.ArrayList;

public class ThrdObj{
    //this is the object that gets put into an array and removed, starts the test also.
    private final Canvas canvas;

    public TestThread getTestThread() {
        return testThread;
    }

    public void setTestThread(TestThread testThread) {
        this.testThread = testThread;
    }

    private TestThread testThread;
    private final mouseListner mouseL;
    HzGUI hzGUI ;
    ArrayList<ThrdObj> threadObjects;

    public ThrdObj(Logistics logistics, HzGUI hzGUI, ArrayList<ThrdObj> threadObjects, int index){
        this.mouseL = new mouseListner(this);
        this.hzGUI = hzGUI;
        this.threadObjects = threadObjects;
        canvas = new Canvas();
        hzGUI.add(canvas);
        this.testThread = new TestThread(logistics, canvas, index, this.hzGUI, threadObjects, mouseL);
        canvas.addMouseListener(this.mouseL);


    }
    public void starter() {

        this.testThread.start();

    }
    public void stopper() {
        canvas.removeMouseListener(this.mouseL);
        this.testThread.runTest.getSineWaveThread().Stop();
       // threadObjects.remove(index);
       // threadObjects.add(index, new ThrdObj(logistics,hzFrame,threadObjects,index));

    }
}

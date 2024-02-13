package org.example;


import java.util.ArrayList;

public class ThreadLogistics{
    Logistics logistics;
    HzFrame hzFrame;
    int index = 0;
    ArrayList<ThrdObj> threadObjects = new ArrayList<>();

    public ThreadLogistics(Logistics logistics, HzFrame hzFrame){
        this.hzFrame = hzFrame;
        this.logistics = logistics;
        threadObjects.add(index, new ThrdObj(logistics, hzFrame, threadObjects, index));
        index++;
    }


}


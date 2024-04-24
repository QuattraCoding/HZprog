package org.example;


import java.util.ArrayList;

public class ThreadLogistics{
    //this object makes sure that ThrdObj gets added and removed, that everything works as it should.
    private int index = 0;
    ArrayList<ThrdObj> threadObjects = new ArrayList<>();

    public ThreadLogistics(Logistics logistics, HzGUI hzGUI){

        threadObjects.add(index, new ThrdObj(logistics, hzGUI, threadObjects, index));
        index++;
    }
}


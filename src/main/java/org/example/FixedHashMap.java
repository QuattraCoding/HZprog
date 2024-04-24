package org.example;

import org.example.Frequency;

import java.util.HashMap;
import java.util.List;

public class FixedHashMap {
    private HashMap<Integer , Frequency> frequencyHashMap;
    public FixedHashMap( List< Frequency > frequencies){
        //makes hashmap and reevaluates it everytime its called.
        this.setFrequencyHashMap(new HashMap<>());
        int index = 0;
        for (Frequency f : frequencies) {
            this.getFrequencyHashMap().put(index, f);
            index++;
        }
    }

    public HashMap<Integer, Frequency> getFrequencyHashMap() {
        return frequencyHashMap;
    }

    public void setFrequencyHashMap(HashMap<Integer, Frequency> frequencyHashMap) {
        this.frequencyHashMap = frequencyHashMap;
    }
}

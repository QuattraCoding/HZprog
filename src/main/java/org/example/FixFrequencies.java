package org.example;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FixFrequencies {
    ArrayList<Integer> int1;

    int timesPlayed;

    public FixFrequencies(ArrayList<Sample> samplesArrayList, List<Frequency> frequencies, HashMap<Integer, Frequency> frequencyHashMap){
        generateHashMap(frequencyHashMap, frequencies);
        int index = 0;
        for (Frequency f : frequencies){

            int1.add(index, 0);
            index++;
        }
        setFrequencytoSample(samplesArrayList, frequencies, frequencyHashMap);
    }

    int listSize;
    Random random = new Random();
    public Frequency setFrequencytoSample(ArrayList<Sample> samplesArrayList, List<Frequency> frequencies, HashMap<Integer, Frequency> frequencyHashMap) {

        if (samplesArrayList.size() <= 0){
            this.listSize = frequencies.size();

            int index = random.nextInt(frequencies.size());

            Frequency frequency = frequencyHashMap.get(index);
            frequencies.remove(index);
            frequencyHashMap.remove(index);
            return frequency;
        }
        else if(samplesArrayList.size() >= listSize) {
            return null;
        }
        else {

            int index = random.nextInt(frequencies.size());

            Frequency frequency = frequencyHashMap.get(index);
            frequencies.remove(index);
            frequencyHashMap.remove(index);
            return frequency;
        }

    }

    public void generateHashMap(HashMap<Integer, Frequency> frequencyHashMap, List<Frequency> frequencies){
        int index = 0;
        for(Frequency f : frequencies){
            frequencyHashMap.put(index, f);
            index++;
        }
    }
}

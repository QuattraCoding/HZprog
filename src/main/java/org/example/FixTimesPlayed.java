package org.example;

import org.example.Frequency;

import java.util.List;

public class FixTimesPlayed {

    public int getTimesPlayed(int index){
        return intlist[index];
    }
    int[] intlist;

    public FixTimesPlayed(List<Frequency> frequencies){
        int index = 0;
        for (Frequency f : frequencies){

            intlist = new int[frequencies.size()];
            intlist[index] = 0;
            index++;
        }
    }

}



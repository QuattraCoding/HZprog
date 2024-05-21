package org.example;

import java.util.List;

public class TimesPlayedFixer {

    public int getTimesPlayed(int index){
        return intlist[index];
    }
    public int[] intlist;

    public TimesPlayedFixer(List<Frequency> frequencies){
        //creates trackers for each time a Frequency is played.
        int index = 0;
        for (Frequency f : frequencies){

            intlist = new int[frequencies.size()];
            intlist[index] = 0;
            index++;
        }
    }

}



package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FrequencyGenerator {

    Map<Integer, Frequency> frequenciesMap;

    public FrequencyGenerator(List<Frequency> frequencies) {
        int index = 1;
        frequenciesMap = new HashMap<>();
        for(Frequency f : frequencies){
            frequenciesMap.put(index++, f);
        }
        //this.frequencies = frequencies;
    }

    public Frequency randomiseFrequency(){
        /** randomises Hz and connects to Real hz*/
        Random random = new Random();

        frequencies.put(2, new Frequency("C3", 130.8f));

        frequencies.put(3, new Frequency("G3", 196f));

        frequencies.put(4, );

        frequencies.put(5, );

        return frequencies.get(random.nextInt(frequenciesMap.size()));
    }
}

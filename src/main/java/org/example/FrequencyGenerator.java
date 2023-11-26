package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FrequencyGenerator {

    Random random = new Random();
    public Map<Integer, Frequency> frequenciesMap;

    public FrequencyGenerator(List<Frequency> frequencies) {
        int index = 1;
        frequenciesMap = new HashMap<>();
        for(Frequency f : frequencies){
            frequenciesMap.put(index++, f);
        }


    }

    public Frequency randomiseFrequency(){
        /** randomises Hz and connects to Real hz*/

        return frequenciesMap.get(random.nextInt(frequenciesMap.size()));

    }
}

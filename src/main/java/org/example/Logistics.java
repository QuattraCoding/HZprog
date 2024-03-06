package org.example;

import org.example.FixTimesPlayed;
import org.example.FixedHashMap;
import org.example.Frequency;
import org.example.PlaySound;

import java.util.List;

public class Logistics {
    int checker = 0;
    boolean isRunning = true;
    //Skapar Hashmap (Fungerar)
    FixedHashMap fixedHashMap;
    //Skapar IntArray med gånger spelade (Fungerar)
    FixTimesPlayed fixTimesPlayed;
    // Skapar körbar ljudmetod och liknande (fungerar)
    PlaySound playSound = new PlaySound();
    int i2;
    public Logistics(List<Frequency> frequencies){
        this.fixedHashMap = new FixedHashMap(frequencies);
        this.fixTimesPlayed = new FixTimesPlayed(frequencies);
    }
    public void stopSound() {

        playSound.stopSound();
    }
    // väljer frekvens slumpmässigt och stannar efter varje frekvens är klar
    public Frequency ChooseFrequency() {

        i2 = playSound.rollNumber(fixedHashMap.getFrequencyHashMap());
        do {

            if (fixTimesPlayed.intlist[i2] < 4) {
                fixTimesPlayed.intlist[i2]++;

                return fixedHashMap.getFrequencyHashMap().get(i2);

            } else if (fixTimesPlayed.intlist[i2] > 4) {
                i2 = playSound.rollNumber(fixedHashMap.getFrequencyHashMap());
                checker++;
                if (checker == fixTimesPlayed.intlist.length) {
                    System.out.println("Inga prov kvar");
                    isRunning = false;
                    return null;

                }
            }
        }while(isRunning);

        return null;}

}


package org.example;

import java.util.List;

public class Logistics {
    private int checker = 0;
    private boolean isRunning = true;
    //Skapar Hashmap (Fungerar)
    public FixedHashMap fixedHashMap;
    //Skapar IntArray med gånger spelade (Fungerar)
    private final TimesPlayedFixer fixTimesPlayed;
    // Skapar körbar ljudmetod och liknande (fungerar)
    SoundPlayer playSound = new SoundPlayer();
    int i2;
    public Logistics(List<Frequency> frequencies){
        this.fixedHashMap = new FixedHashMap(frequencies);
        this.fixTimesPlayed = new TimesPlayedFixer(frequencies);
    }
    public void stopSound() {

        playSound.stopSound();
    }
    // chooses frequency randomly and checks for times played, to make sure it doesn't play that frequency.
    public Frequency ChooseFrequency() {

        i2 = playSound.rollNumber(fixedHashMap.getFrequencyHashMap());
        int counter = 0;
        do {
            System.out.println("Logistic counter " + counter);
            counter++;

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

        }while(isRunning && counter <5);

        return null;}

}


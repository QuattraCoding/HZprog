package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.util.List;

public class SineWaveThread extends Thread{
    private final List<Frequency> frequencies = List.of(new Frequency("E1", 41.2f), new Frequency("C3", 130.8f), new Frequency("G3", 196f), new Frequency("A4", 440f), new Frequency("D5", 597.33f) );
    boolean aBoolean = true;
    Sample sample1;

    int index = 1;

    @Override
    public void run() {
        try {
            sample1 = new Sample(new FrequencyGenerator(frequencies));
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }

        do {
            sample1.playSound();
            System.out.println(index);
            index++;
            try {
                Thread.sleep( (long)(sample1.buf.length / (200 * Math.PI)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } while(aBoolean);




    }
}

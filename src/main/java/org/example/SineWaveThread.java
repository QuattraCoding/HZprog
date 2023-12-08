package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.util.*;

public class SineWaveThread extends Thread{

    public SineWaveThread(ArrayList<Sample> samples, FixFrequencies fixFrequencies){




    }

    Sample sample1;
    boolean aBoolean = true;
    int index = 1;

    @Override
    public void run() {

        playSample(sample1);


    }


    public void playSample(Sample sample){
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

package org.example;

import org.example.Frequency;
import org.example.Logistics;

public class SineWaveThread extends Thread {
    //Object that runs the test in a different thread so that the whole program doesnt stop.
    boolean onSwitch = true;
    private final Logistics logistics;
    public SineWaveThread(Logistics logistics ){
    this.logistics = logistics;


    }

    @Override
    public void run() {
        //plays sample enables it to play on a loop.

        Frequency f = logistics.ChooseFrequency();
        playSample(f);
        System.out.println(f.getName());

    }
    public void Stop() {
        onSwitch = false;
    }
    public void playSample(Frequency frequency){
        logistics.playSound.generateSineWave(frequency);
        int count= 0;
        do {
            System.out.println("SinWaveThreead counter " + count);
            count++;
            logistics.playSound.playSound();
            try {
                Thread.sleep( (long) (logistics.playSound.buf.length / (200 * Math.PI)));
            } catch (InterruptedException e) {
                System.out.println("Ultragay");
                throw new RuntimeException(e);
            }

        } while(onSwitch && count <5);
        logistics.playSound.stopSound();
    }

}
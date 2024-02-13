package org.example;

import org.example.Frequency;
import org.example.Logistics;

public class SineWaveThread extends Thread {
    boolean onSwitch = true;
    Logistics logistics;
    public SineWaveThread(Logistics logistics ){
    this.logistics = logistics;


    }

    @Override
    public void run() {

        playSample(logistics.ChooseFrequency());

    }
    public void Stop() {
        onSwitch = false;
    }
    public void playSample(Frequency frequency){
        logistics.playSound.generateSineWave(frequency);
        do {
            logistics.playSound.playSound();
            try {
                Thread.sleep( (long) (logistics.playSound.buf.length / (200 * Math.PI)));
            } catch (InterruptedException e) {
                System.out.println("Ultragay");
                throw new RuntimeException(e);
            }
        } while(onSwitch);
        logistics.playSound.stopSound();
    }

}
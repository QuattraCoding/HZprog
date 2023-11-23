package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Random;
import javax.sound.sampled.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Sample {
    //Attribute
    private String name;
    private float hz;
    private int vol =  1;
    static float SAMPLE_RATE = 44100f;
    byte[] buf = new byte[(int)SAMPLE_RATE];
    public SourceDataLine sdl;
    public StopWatch time = new StopWatch();

    /** https://groups.google.com/g/comp.lang.java.help/c/7vR_AWw1AwQ?pli=1 */
    public void sound()
            throws LineUnavailableException {
        this.hz = randomiseHz();
        if (hz <= 0)
            throw new IllegalArgumentException("Frequency <= 0 hz");


        for (int i=0; i<buf.length; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[i] = (byte)(Math.sin(angle) * 127.0 * vol);
        }

// shape the front and back 10ms of the wave form
        for (int i=0; i < SAMPLE_RATE / 100.0 && i < buf.length / 2; i++) {
            buf[i] = (byte)(buf[i] * i / (SAMPLE_RATE / 100.0));
            buf[buf.length-1-i] =
                    (byte)(buf[buf.length-1-i] * i / (SAMPLE_RATE / 100.0));
        }

        AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
        this.sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
    }

    public void playSound(){
        sdl.write(buf, 0, buf.length);
    }

    public void stopSound(){
        sdl.drain();
        sdl.close();
    }
    public float randomiseHz(){
        /**randomises Hz and connects to Real hz*/
        Random r = new Random();
        switch(r.nextInt(5)){
            case 1 -> {
                name = "E1";
                return 41.2F;
            }
            case 2 -> {
                name = "C3";
                return 130.81F;
            }
            case 3 -> {
                name = "G3";
                return 196F;

            }
            case 4 -> {
                name = "A4";
                return 440F;

            }
            case 5 -> {
                this.name = "D5";
                return 587.33F;
            }
            default -> {
                return 0;
            }
        }
    }

}


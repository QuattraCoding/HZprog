package org.example;

import org.example.Frequency;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.HashMap;
import java.util.Random;


public class PlaySound {
    //makes sound play and activates a audioinputStream.
    float SAMPLE_RATE = 44100f;

    final byte[] buf = new byte[(int) SAMPLE_RATE];
    private SourceDataLine sDataLine;
    private final Random random = new Random();
    public int rollNumber(HashMap<Integer, Frequency> frequencies){
        return random.nextInt(frequencies.size());
    }
    public PlaySound(){

    }
    public void generateSineWave(Frequency frequency) {
        //generates the sinewave connected to the frequency.

        final int vol = 1;
        final double SAMPLE_RATED_DIV_BY_100 = SAMPLE_RATE / 100.0;

        if (frequency.getFrequency() <= 0) {
            throw new IllegalArgumentException("Frequency <= 0 hz");
        }

        for (int i = 0; i < buf.length; i++) {
            double angle = i / (SAMPLE_RATE / frequency.getFrequency()) * 2.0 * Math.PI;
            buf[i] = (byte) (Math.sin(angle) * 127.0 * vol);
        }

// shape the front and back 10ms of the wave form
        for (int i = 0; i < SAMPLE_RATED_DIV_BY_100 && i < buf.length / 2; i++) {
            buf[i] = (byte) (buf[i] * i / SAMPLE_RATED_DIV_BY_100);
            buf[buf.length - 1 - i] =
                    (byte) (buf[buf.length - 1 - i] * i / SAMPLE_RATED_DIV_BY_100);
        }

        AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
        try {
            this.sDataLine = AudioSystem.getSourceDataLine(audioFormat);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            sDataLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void playSound(){
        sDataLine.start();
        sDataLine.write(buf, 0, buf.length);
    }

    public void stopSound(){
        sDataLine.drain();
        sDataLine.close();
    }

}

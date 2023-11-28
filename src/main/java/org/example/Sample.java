package org.example;

import javax.sound.sampled.*;

public class Sample {
    //Attribute
    private final int vol =  1;
    static float SAMPLE_RATE = 44100f;
    public static final double SAMPLE_RATE_DIV_BY_100 = SAMPLE_RATE / 100.0;
    byte[] buf = new byte[(int)SAMPLE_RATE];
    public SourceDataLine sDataLine;
    FrequencyGenerator frequencyGenerator;

    Frequency frequency;
    boolean buttonClicked = false;


    public Sample(FrequencyGenerator frequencyGenerator)
            throws LineUnavailableException {
        this.frequencyGenerator = frequencyGenerator;
        generateSineWave();
    }

    /** https://groups.google.com/g/comp.lang.java.help/c/7vR_AWw1AwQ?pli=1 */
    public void generateSineWave(){

        frequency = frequencyGenerator.randomiseFrequency();
        System.out.println(frequency.getFrequency());
        if (frequency.getFrequency() <= 0){
            throw new IllegalArgumentException("Frequency <= 0 hz");
        }

        for (int i=0; i<buf.length; i++) {
            double angle = i / (SAMPLE_RATE / frequency.getFrequency()) * 2.0 * Math.PI;
            buf[i] = (byte)(Math.sin(angle) * 127.0 * vol);
        }

// shape the front and back 10ms of the wave form
        for (int i = 0; i < SAMPLE_RATE_DIV_BY_100 && i < buf.length / 2; i++) {
            buf[i] = (byte)(buf[i] * i / SAMPLE_RATE_DIV_BY_100);
            buf[buf.length-1-i] =
                    (byte)(buf[buf.length-1-i] * i / SAMPLE_RATE_DIV_BY_100);
        }

        AudioFormat audioFormat = new AudioFormat(SAMPLE_RATE,8,1,true,false);
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

        if(buttonClicked){
            sDataLine.drain();
            sDataLine.close();
        }
    }

}


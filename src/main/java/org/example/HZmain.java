package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class HZmain
{
    static SineWaveThread sineWaveThread = new SineWaveThread();
    HzProgram hzprogram = new HzProgram();
    public static void main( String[] args ) throws LineUnavailableException {
        sineWaveThread.start();

    }
    }

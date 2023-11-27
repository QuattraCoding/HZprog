package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class HZmain
{
    static SineWaveThread sineWaveThread = new SineWaveThread();

    public static void main( String[] args ) throws LineUnavailableException {

        new HzProgram();

    }
    }

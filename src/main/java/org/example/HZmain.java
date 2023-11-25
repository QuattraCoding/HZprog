package org.example;

import javax.sound.sampled.LineUnavailableException;

public class HZmain
{
    public static void main( String[] args )throws
            LineUnavailableException
    {
        HzProgram t = new HzProgram();
        Frequency frequency = new Frequency();
        frequency.randomiseFrequency();
        System.out.println(frequency.hz);
        System.out.println(frequency.name);
    }
    }

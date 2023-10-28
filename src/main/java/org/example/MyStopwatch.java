package org.example;

import org.apache.commons.lang3.time.StopWatch;
import org.jfugue.player.Player;

import java.io.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

public class MyStopwatch {

    private Scanner scan = new Scanner(System.in);
    private boolean b = true;
    private Random random = new Random();
    public StopWatch time = new StopWatch();


    public MyStopwatch(){

    }

    public long randomiseTime(){

        long l = (long) random.nextInt(11) + 1;
        return l;
    }
    public void reactionTimer(){
        long a = randomiseTime();
        time.start();
    do{
        if(time.getTime(TimeUnit.SECONDS) == a) {
            String input;
            //First time since start saved here
            long t1 = (long) time.getTime(TimeUnit.MILLISECONDS);
            System.out.println("HELL YEAH");
            do {
                InputStreamReader sReader = new InputStreamReader(System.in);
                String verf = sReader.read();

                //If statement that shows if the string isn't empty.
                if (verf != null) {
                    //Second time saved here
                    time.split();
                    long t2 = time.getSplitTime();
                    System.out.println(t2 + " : t2");
                    System.out.println(t1 + " : t1");
                    System.out.println(a + " är slumpmässigt tid");
                    long tResult = t2 - t1;
                    System.out.println("Millisekunder som har gått mellan intervallen är: " + tResult);
                    break;
                }


            }while(time.getTime(TimeUnit.SECONDS) >= a);


        }
    }while(b);


    }

}


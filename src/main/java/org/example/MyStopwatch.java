package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class MyStopwatch {
    boolean b = true;
    public TimeUnit t;
    Random random = new Random();
     public StopWatch time = new StopWatch();
    // long randomTime = randomiseTime();

    public MyStopwatch(){

    }

    public long randomiseTime(){
        long rTime = (long) random.nextInt(10);
        return rTime;
    }
    public void reactionTimer(){
        long a = randomiseTime();
        time.start();
    do{
        if(time.getTime(TimeUnit.SECONDS) == a){
            System.out.println("HELL YEAH");
            b = false;
        }
    }while(b);


    }

}


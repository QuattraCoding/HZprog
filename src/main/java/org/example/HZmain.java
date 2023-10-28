package org.example;
import org.jfugue.*;
import org.jfugue.player.Player;

import java.io.IOException;

public class HZmain
{
    static MyStopwatch t = new MyStopwatch();
    public static void main( String[] args )
    {
        try {
            t.reactionTimer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

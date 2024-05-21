package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseListenerObj implements MouseListener {
    //switches from on and off depending on value of boolean inside mouselistener.
    private final ThrdObj thrdObj;
    private boolean started = false;
    mouseListenerObj(ThrdObj thrdObj) {
        this.thrdObj = thrdObj;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!this.started) {
            this.started = true;
            thrdObj.starter();
        } else {
            this.started = false;
            thrdObj.stopper();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

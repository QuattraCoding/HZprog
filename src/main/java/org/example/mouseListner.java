package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseListner implements MouseListener {
    ThrdObj sexy;

    boolean started = false;
    mouseListner(ThrdObj sexy) {
        this.sexy = sexy;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!this.started) {
            this.started = true;
            sexy.starter();
        } else {
            this.started = false;
            sexy.stopper();
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

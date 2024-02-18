/**
 * File: Ensemble.java
 * ---------------------
 * this is program for multi-threads player
 */

package com.rbpiano.rainbowpiano.Model;

import javax.sound.midi.MidiUnavailableException;


public class Ensemble implements Runnable{

    private int selectID;

    private PlayList playList;

    public Ensemble(int id, PlayList list){
        selectID = id;
        playList = list;
    }

    /**
     * play the music on the playlist by index selectID
     */
    @Override
    public void run() {

        try {
            playList.playMusic(selectID);
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

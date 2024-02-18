/**
 * File: Recorder.java
 * ---------------------
 * this is program for Recorder
 */

package com.rbpiano.rainbowpiano.Model;


public class Recorder {

    private static boolean recording;

    public Recorder(boolean initalRecord){

        recording = initalRecord;

    }

    public boolean setStartRecording(){

       return recording = true;
    }

    public boolean setFinishRecording(){

        return recording = false;
    }



    public boolean recorderIsStarted(){
        if(recording) {
            return true;
        }
        else{
            return false;
        }
    }
}








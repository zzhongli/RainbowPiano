package com.rbpiano.rainbowpiano.Model;



import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.ArrayList;

public class PianoNote {

    private Synthesizer synthesizer = MidiSystem.getSynthesizer();
    private MidiChannel channel = synthesizer.getChannels()[0];

    private int Notenumber;

    private ArrayList<Integer> newmusic;

    public PianoNote(int number) throws MidiUnavailableException {
        Notenumber = number;

    }

    public PianoNote() throws MidiUnavailableException {

    }

    public void setNote(int notnum){
        Notenumber = notnum;
    }




    public void playNote() throws MidiUnavailableException, InterruptedException {

        synthesizer.open();
        channel.noteOn(Notenumber, 100);
        channel.noteOff(Notenumber);


    }

    public void addToMusic(int noteNumber){
        noteNumber = Notenumber ;
        newmusic.add(noteNumber);


    }


    public Music makeMusic() throws MidiUnavailableException {

        Music m = new Music(newmusic);
        return m;

    }

//    public void isRecording(){
//
//      }


    public int getNotenumber() {
        return Notenumber;
    }
}



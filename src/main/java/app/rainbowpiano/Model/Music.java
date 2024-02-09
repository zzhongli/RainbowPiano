package app.rainbowpiano.Model;


import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.ArrayList;

public class Music extends ArrayList{

    private Synthesizer synthesizer = MidiSystem.getSynthesizer();
    private MidiChannel channel = synthesizer.getChannels()[0];
    private  ArrayList<Integer> newmusic;
    private String musicName;
    public Music(ArrayList<Integer> notes, String name) throws MidiUnavailableException {
        newmusic = notes;
        musicName = name;

    }

    public Music(ArrayList<Integer> notes) throws MidiUnavailableException {
        newmusic = notes;
    }

    public Music() throws MidiUnavailableException {

    }


    public void play() throws MidiUnavailableException, InterruptedException {
        for(int i = 0; i < newmusic.size(); i++) {
            synthesizer.open();
            channel.noteOn(newmusic.get(i), 100);
            Thread.sleep(300);
            channel.noteOff(newmusic.get(i));
        }

    }


    public void addNote(int noteNumber){
        newmusic.add(noteNumber);
    }

//    public Music makeMusic() throws MidiUnavailableException {
//
//        Music m = new Music(newmusic);
//        return m;
//
//    }


    public void addTo(PlayList list){


    }




    public void delete(){
        for(int i = 0; i < 10; i++){
            newmusic.clear();
        }

    }

    public String setMusicName(String musicName) {
        return this.musicName = musicName;
    }

    public String getMusicName() {
        return musicName;
    }
}


package com.rbpiano.rainbowpiano.Model;



import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;

public class PlayList extends ArrayList{

    private static ArrayList<Music> PlayList1 = new ArrayList<Music>();

    private String musicName;
    public PlayList(){

    }
    public void addMusic(Music mus){

        PlayList1.add(mus);

    }


    public ArrayList<String> getMusicName(){

        ArrayList<String> s = new ArrayList<String>();
        for(int i = 0; i < PlayList1.size(); i++){
            if(PlayList1.isEmpty()) break;
            s.add(PlayList1.get(i).getMusicName());

        }
        return s;


    }

    public void playMusic(int idNumber) throws MidiUnavailableException, InterruptedException {
        PlayList1.get(idNumber).play();
    }

    public void deleteMusic(int musicIndex){
        PlayList1.remove(musicIndex);

    }

    public int getMusicIndex(){
        return PlayList1.size();
    }



}

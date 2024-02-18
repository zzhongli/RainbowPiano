/**
 * File: PianoNoteController.java
 * ---------------------
 * this is piano note screen class
 */

package com.rbpiano.rainbowpiano;

import com.rbpiano.rainbowpiano.Model.PianoNote;
import com.rbpiano.rainbowpiano.Model.Music;
import com.rbpiano.rainbowpiano.Model.PlayList;
import com.rbpiano.rainbowpiano.Model.Recorder;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import static java.lang.StringTemplate.STR;

public class PianoNoteController {
    public static PlayList list = new PlayList();

    private static MainScreenController controller = new MainScreenController();

    private static Recorder Recorder = new Recorder(false);

    public ArrayList<Integer> newmusic = new ArrayList<Integer>();
    public Music music = new Music(newmusic);

    private static PianoNote note;

    static {
        try {
            note = new PianoNote();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public PianoNoteController() throws MidiUnavailableException {
    }

    @FXML
    public void noteA3Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(57);
        note.playNote();
        //put in the recorder list
        if(Recorder.recorderIsStarted()){
            music.addNote(57);
        }
    }

    @FXML
    public void a3bb3ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(58);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(58);
        }
    }

    @FXML
    public void noteB3Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(59);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(59);
        }
    }

    @FXML
    public void noteC4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(60);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(60);
        }
    }

    @FXML
    public void db4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(61);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(61);
        }
    }

    @FXML
    public void noteD4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(62);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(62);
        }
    }

    @FXML
    public void eb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(63);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(63);
        }
    }

    @FXML
    public void noteE4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(64);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(64);
        }
    }

    @FXML
    public void noteF4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(65);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(65);
        }
    }

    @FXML
    public void gb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(66);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(66);
        }
    }

    @FXML
    public void noteG4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(67);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(67);
        }
    }

    @FXML
    public void ab4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(68);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(68);
        }
    }

    @FXML
    public void noteA4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(69);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(69);
        }
    }

    @FXML
    public void bb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(70);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(70);
        }
    }

    @FXML
    public void noteB4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(71);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(71);
        }
    }

    @FXML
    public void noteC5Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(72);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(72);
        }
    }

    @FXML
    public void db5ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(73);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(73);
        }
    }

    @FXML
    public void noteD5Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(74);
        note.playNote();
        if(Recorder.recorderIsStarted()){
            music.addNote(74);
        }
    }


    public void startRecordingClicked() throws MidiUnavailableException {

        Recorder.setStartRecording();

    }


    public void finishRecordingClicked() throws MidiUnavailableException, InterruptedException, IOException {
        if(Recorder.recorderIsStarted()) {
            Recorder.setFinishRecording();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Rainbow Piano");
            alert.setContentText("Do you want to save your music to the playlist?");

            ButtonType yes = new ButtonType("Yes, Go to Playlist");
            ButtonType no = new ButtonType("No");

            alert.getButtonTypes().clear();   //remove default alert option setting
            alert.getButtonTypes().addAll(yes, no);  //add customize option

            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == yes) {

                /**
                 * add this music be created to the playlist
                 */
                list.addMusic(music);

                music.setMusicName(STR."Music- at \{LocalTime.now().getHour()}" + STR.":\{LocalTime.now().getMinute()}" + STR.":\{LocalTime.now().getSecond()}");
                controller.playListButtonClicked();

            } else if (action.get() == no) {

            }
        }
        else{

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Rainbow Piano");
            alert1.setContentText("You have not start recording yet.");
            Optional<ButtonType> action1 = alert1.showAndWait();

        }
    }

    public void PlayListButtonClicked() throws IOException {
        controller.playListButtonClicked();

    }



}

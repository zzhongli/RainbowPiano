package app.rainbowpiano;


import app.rainbowpiano.Model.PianoNote;
import app.rainbowpiano.Model.Music;
import app.rainbowpiano.Model.PlayList;
import app.rainbowpiano.Model.Recorder;
import app.rainbowpiano.Model.PianoNote;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static java.lang.StringTemplate.STR;

public class PianoNoteController {
    public static PlayList list = new PlayList();

    private static MainScreenController controller = new MainScreenController();

    private static Recorder Recorder = new Recorder();
    private static boolean recording;

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

    public void noteA3Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(57);
        note.playNote();
        //put in the recorder list
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(57);
        }
    }

    public void a3bb3ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(58);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(58);
        }
    }

    public void noteB3Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(59);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(59);
        }
    }


    @FXML
    public void noteC4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(60);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(60);
        }
    }


    public void db4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(61);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(61);
        }
    }

    public void noteD4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(62);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(62);
        }
    }


    public void eb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(63);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(63);
        }
    }

    public void noteE4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(64);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(64);
        }
    }

    public void noteF4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(65);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(65);
        }
    }

    public void gb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(66);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(66);
        }
    }

    @FXML
    public void noteG4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(67);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(67);
        }
    }

    public void ab4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(68);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(68);
        }
    }

    @FXML
    public void noteA4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(69);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(69);
        }
    }

    public void bb4ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(70);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(70);
        }
    }


    public void noteB4Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(71);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(71);
        }
    }

    public void noteC5Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(72);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(72);
        }
    }

    public void db5ButtonClicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(73);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(73);
        }
    }

    public void noteD5Clicked() throws MidiUnavailableException, InterruptedException {
        note.setNote(74);
        note.playNote();
        if(Recorder.recorderIsStarted(recording)){
            music.addNote(74);
        }
    }




    public void startRecordingClicked() throws MidiUnavailableException {
        recording = true;

    }

    public void finishRecordingClicked() throws MidiUnavailableException, InterruptedException, IOException {
        recording = false;
        // list.add(Recorder.convertToMusic(newmusic));
        //pop up option panel
        //do you want to save your music to the playlist
        //yes or no
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Rainbow Piano");
        alert.setContentText("Do you want to save your music to the playlist?");

        ButtonType yes = new ButtonType("Yes, Go to Playlist");
        ButtonType no = new ButtonType("No");
        ButtonType cancel = new ButtonType("Cancel");

        alert.getButtonTypes().clear();   //remove default alert option setting
        alert.getButtonTypes().addAll(yes,no,cancel);  //add customize option

        Optional<ButtonType> action = alert.showAndWait();

        if(action.get() == yes){

            /**
             * add this music be created to the playlist
             */
            list.addMusic(music);

            music.setMusicName(STR."Music-\{list.getMusicIndex()}");
            controller.playListButtonClicked();

        } else if (action.get()== no) {
            // newmusic.clear();


        } else if (action.get()==cancel) {


        }


    }
//    public void playButtonClicked() throws MidiUnavailableException, InterruptedException {
//        // Music mu = Recorder.convertToMusic(newmusic);
//
//        //Music mu = new Music(newmusic,"hi");
//        //list.addMusic(mu);
////        music.play();
//        // System.out.println(list.getMusicName()[0]);
////        for(int i = 0; i < 10; i++){
////            synthesizer.open();
////            channel.noteOn(newmusic.get(i), 100);
////            Thread.sleep(200);
////            channel.noteOff(newmusic.get(i));
////        }
//
//    }

    public void PlayListButtonClicked() throws IOException {
        controller.playListButtonClicked();


    }




}

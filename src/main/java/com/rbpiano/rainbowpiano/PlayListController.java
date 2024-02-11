package com.rbpiano.rainbowpiano;


import com.rbpiano.rainbowpiano.Model.PlayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;

import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlayListController implements Initializable {

    private static MainScreenController controller = new MainScreenController();
    private static PlayList l = new PlayList();


    @FXML
    private ListView<String> musicListView;

    @FXML
    private ListView<String> ensembleListView;

    public PlayListController() throws MidiUnavailableException {
    }

    /**
     * switch to piano scene
     */
    public void pianoButtonClicked() throws IOException, IOException {
        controller.pianoButtonClicked();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> o = l.getMusicName();
        musicListView.getItems().addAll(o);

    }

    /**
     * delete music from the list
     */
    public void deleteMusicListViewButtonClicked(){
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        musicListView.getItems().remove(selectedID);
        ensembleListView.getItems().remove(selectedID);
        l.deleteMusic(selectedID);

    }

    /**
     * play music from the list
     */
    public void playMusicListViewButtonClicked() throws MidiUnavailableException, InterruptedException {
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        l.playMusic(selectedID);
    }

    /**
     * add music from playlist to another playlist
     */
    public void addToEnsembleButtonClicked(){
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        String g = musicListView.getSelectionModel().getSelectedItem();
        ensembleListView.getItems().add(g);
    }


    public void playEnsembleListViewButtonClicked() throws MidiUnavailableException, InterruptedException {
        int selectedID =ensembleListView.getSelectionModel().getSelectedIndex();
        l.playMusic(selectedID);
    }

    public void deleteEnsembleListViewButtonClicked(){
        int selectedID =ensembleListView.getSelectionModel().getSelectedIndex();
        ensembleListView.getItems().remove(selectedID);
    }

    public void ensembleButtonClicked(){


    }
}

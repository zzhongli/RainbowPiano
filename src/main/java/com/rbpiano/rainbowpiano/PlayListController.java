/**
 * File: PlayListController.java
 * ---------------------
 * this is playlist screen class
 */

package com.rbpiano.rainbowpiano;

import com.rbpiano.rainbowpiano.Model.Ensemble;
import com.rbpiano.rainbowpiano.Model.PlayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

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
    @FXML
    public void pianoButtonClicked() throws IOException, IOException {
        controller.pianoButtonClicked();
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> o = l.getMusicName();
        musicListView.getItems().addAll(o);
        ensembleListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    /**
     * delete music from the list
     */
    @FXML
    public void deleteMusicListViewButtonClicked(){
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        musicListView.getItems().remove(selectedID);
        if(!ensembleListView.getItems().isEmpty()){
            ensembleListView.getItems().remove(selectedID);
        }
        l.deleteMusic(l.size());

    }

    /**
     * play music from the list
     */
    @FXML
    public void playMusicListViewButtonClicked() throws MidiUnavailableException, InterruptedException {
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        l.playMusic(selectedID);
    }

    /**
     * add music from playlist to another playlist
     */
    @FXML
    public void addToEnsembleButtonClicked(){
        int selectedID =musicListView.getSelectionModel().getSelectedIndex();
        String g = musicListView.getSelectionModel().getSelectedItem();
        ensembleListView.getItems().add(g);
    }

    @FXML
    public void deleteEnsembleListViewButtonClicked(){
        int selectedID =ensembleListView.getSelectionModel().getSelectedIndex();
        ensembleListView.getItems().remove(selectedID);
        l.deleteMusic(l.size());
    }

    @FXML
    public void ensembleButtonClicked() throws MidiUnavailableException, InterruptedException {

        ObservableList<Integer> selectedID =ensembleListView.getSelectionModel().getSelectedIndices();

        for(int i=0; i < selectedID.size();i++){

            Ensemble ensemble = new Ensemble(selectedID.get(i),l);
            Thread t = new Thread(ensemble);
            t.start();

        }
    }
}

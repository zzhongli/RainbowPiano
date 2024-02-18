/**
 * File: MainScreenController.java
 * ----------------------------------
 * This is the Main Screen Class to switching Piano Screen and PlayList Screen
 */

package com.rbpiano.rainbowpiano;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    private static Stage stage = new Stage();

    public MainScreenController(){

    }

    public void pianoButtonClicked() throws IOException {

        //switch to piano scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PianoNote.fxml"));
        Scene scene1 = new Scene(loader.load());
        stage.setScene(scene1);
        stage.setResizable(false);
        stage.setTitle("Piano Keyboard");
        stage.show();
    }

    public void playListButtonClicked() throws IOException {
        //switch to scene playlist
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayList.fxml"));
        Scene scene2 = new Scene(loader.load());
        stage.setScene(scene2);
        stage.setResizable(false);
        stage.setTitle("MyPlayList");
        stage.show();
    }

}


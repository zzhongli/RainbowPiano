/**
 * File: Main.java
 * ---------------------
 * this is class to start program
 */

package com.rbpiano.rainbowpiano;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Rainbow Piano");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("icon.png"));
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
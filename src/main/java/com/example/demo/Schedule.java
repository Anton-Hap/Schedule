package com.example.demo;

import com.example.demo.constants.Data;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Schedule extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Schedule.class.getResource("MenuWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("BARSU Schedule");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.getIcons().add(new Image(Data.ICON_PATH));
        stage.setScene(scene);
        stage.show();
        Data.STAGE = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}
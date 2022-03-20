package com.example.demo;

import com.example.demo.constants.Data;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class WindowUtils {

    public static void updateWindow(String address, Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        Data.STAGE = stage;

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(WindowUtils.class.getResource("" + address));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(new Scene(loader.getRoot()));
        stage.centerOnScreen();
        stage.show();
    }

    public static void openNewWindow(String address, Button button) {
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(WindowUtils.class.getResource("" + address));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        Data.STAGE = stage;

        stage.setTitle("BARSU Schedule");
        stage.setResizable(false);
        stage.getIcons().add(new Image(Data.ICON_PATH));
        stage.setScene(new Scene(loader.getRoot()));
        stage.centerOnScreen();
        stage.show();
    }

    public static void closeWindow() {
        Data.STAGE.setOnCloseRequest(event -> {

        });
    }
}

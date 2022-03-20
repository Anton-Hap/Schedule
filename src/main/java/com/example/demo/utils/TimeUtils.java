package com.example.demo.utils;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.util.Date;

public abstract class TimeUtils {

    public static void showAndHideLabel(Label label, String text, int milliseconds) {
        label.setText(text);

        new Thread(() -> {
            Date oldDate = new Date();

            while (true) {
                Date newDate = new Date();

                if (newDate.getTime() - oldDate.getTime() > milliseconds) {
                    Platform.runLater(() -> {
                        label.setText("");
                    });

                    break;
                }
            }
        }).start();
    }
}

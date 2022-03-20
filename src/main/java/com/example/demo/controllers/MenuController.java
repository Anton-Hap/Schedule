package com.example.demo.controllers;

import com.example.demo.models.LocalData;
import com.example.demo.utils.ScheduleUtils;
import com.example.demo.WindowUtils;
import com.example.demo.utils.TimeUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MenuController {

    @FXML
    private Button ShowButton, settingsButton, updateButton;

    @FXML
    private Label messageLabel, facultyLabel, specialityLabel, groupLabel, weekLabel;

    @FXML
    void initialize() {
        LocalData localData = ScheduleUtils.getLocalData();

        setPrimaryValue(localData);

        updateButton.setOnAction(event -> {
            localData.setWeek(ScheduleUtils.getCurrentWeek());

            try {
                ScheduleUtils.updateSchedule(localData);
                messageLabel.setTextFill(Color.web("#00FA9A"));

                TimeUtils.showAndHideLabel(messageLabel, "Расписание скачено", 2000);

                weekLabel.setText(localData.getWeek());
            } catch (Exception e) {
                messageLabel.setTextFill(Color.web("#FA8072"));
                TimeUtils.showAndHideLabel(messageLabel, "Расписания на эту неделю нет", 2000);
            }
        });

        settingsButton.setOnAction(actionEvent -> {
            WindowUtils.updateWindow("SettingsWindow.fxml", settingsButton);
        });

        ShowButton.setOnAction(actionEvent -> {
            try {
                if (!localData.getFaculty().equals(""))
                    WindowUtils.updateWindow("demo.fxml", ShowButton);
            } catch (Exception e) {
                TimeUtils.showAndHideLabel(messageLabel, "Ваши данные пусты\nЗагрузите расписание", 2000);
            }
        });
    }

    private void go() {
        messageLabel.setText("");
    }

    private void setPrimaryValue(LocalData localData) {
        if (localData.getFaculty().length() > 30) {
            facultyLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 14));
            facultyLabel.setWrapText(true);
        }
        facultyLabel.setText(localData.getFaculty());

        if (localData.getSpeciality().length() > 30) {
            if (localData.getSpeciality().length() > 40) {
                if (localData.getSpeciality().length() > 50) {
                    specialityLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 11));
                } else {
                    specialityLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 13));
                }
            } else {
                specialityLabel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 14));
            }
            specialityLabel.setWrapText(true);
        }
        specialityLabel.setText(localData.getSpeciality());

        groupLabel.setText(localData.getGroup());
        weekLabel.setText(localData.getWeek());
    }
}
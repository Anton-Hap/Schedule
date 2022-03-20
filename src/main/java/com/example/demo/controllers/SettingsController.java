package com.example.demo.controllers;

import com.example.demo.constants.Data;
import com.example.demo.models.GlobalData;
import com.example.demo.utils.ReadConfigUtils;
import com.example.demo.utils.ScheduleUtils;
import com.example.demo.WindowUtils;
import com.example.demo.utils.TimeUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;


import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class SettingsController {

    @FXML
    private ComboBox<String> facultyBox, specialityBox, groupBox;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField weekField;

    @FXML
    private Button updateButton, menuButton;

    @FXML
    private RadioButton currentWeek, nextWeek, ownWeek;

    @FXML
    void initialize() {
        GlobalData globalData = ScheduleUtils.getGlobalData();

        ownWeek.fire();

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(currentWeek, nextWeek, ownWeek);

        setStartValue();

        facultyBox.setVisibleRowCount(5);
        specialityBox.setVisibleRowCount(5);
        groupBox.setVisibleRowCount(5);

        facultyBox.getItems().addAll(globalData.getFaculty());
        specialityBox.getItems().addAll(globalData.getSpeciality().getSpeciality());
        groupBox.getItems().addAll(globalData.getGroup().getGroup());

        currentWeek.setOnAction(event -> {
                changeEditableWeekField();
                weekField.setText(ScheduleUtils.getCurrentWeek());
        });

        nextWeek.setOnAction(event -> {
                changeEditableWeekField();
                weekField.setText(ScheduleUtils.getNextWeek());
        });

        ownWeek.setOnAction(event -> {
            changeEditableWeekField();
            weekField.setText("");
        });

        facultyBox.setOnAction(actionEvent -> {
            specialityBox.getItems().removeAll(globalData.getSpeciality().getSpeciality());

            for (int i = 0; i < globalData.getSpeciality().getSpeciality().size(); i++) {
                if (facultyBox.getValue().equals(globalData.getSpeciality().getFaculty().get(i))) {
                    specialityBox.getItems().add(globalData.getSpeciality().getSpeciality().get(i));
                }
            }
        });

        specialityBox.setOnAction(actionEvent -> {
            groupBox.getItems().removeAll(globalData.getGroup().getGroup());

            for (int i = 0; i < globalData.getGroup().getGroup().size(); i++) {
                if (specialityBox.getValue().equals(globalData.getGroup().getSpeciality().get(i))) {
                    groupBox.getItems().add(globalData.getGroup().getGroup().get(i));
                }
            }
        });

        Pattern pattern = Pattern.compile("[0-9-]{0,10}");
        UnaryOperator<TextFormatter.Change> filter = c -> {
            if (pattern.matcher(c.getControlNewText()).matches()) {
                return c ;
            } else {
                return null;
            }
        };
        TextFormatter<String> formatter = new TextFormatter<>(filter);
        weekField.setTextFormatter(formatter);

        menuButton.setOnAction(actionEvent -> {
            WindowUtils.updateWindow("MenuWindow.fxml", menuButton);
        });

        updateButton.setOnAction(actionEvent -> {
            String faculty = facultyBox.getValue(), speciality = specialityBox.getValue(),
                    group = groupBox.getValue(), week = weekField.getText();

            if (faculty == null || speciality == null || group == null || week.equals("")) {
                messageLabel.setTextFill(Color.web("#FA8072"));
                TimeUtils.showAndHideLabel(messageLabel, "Вы не указали один и пунктов", 2000);
            } else {
                requestUpdate(faculty, speciality, group, week);
            }
        });
    }

    private void setStartValue() {
        messageLabel.setTextFill(Color.web("#4682B4"));
        messageLabel.setText("Во время обновления расписания\nНе используйте приложение");
    }

    private void requestUpdate(String faculty, String speciality, String group, String week) {
        try {
            ScheduleUtils.updateSchedule(faculty, speciality, group, week);
            messageLabel.setTextFill(Color.web("#00FA9A"));
            TimeUtils.showAndHideLabel(messageLabel, "Расписание скачено", 2000);
        } catch (Exception e) {
            messageLabel.setTextFill(Color.web("#FA8072"));
            TimeUtils.showAndHideLabel(messageLabel, "Расписания на эту неделю нет", 2000);
        }
    }

    private void changeEditableWeekField() {
        if (ownWeek.isSelected()) {
            weekField.setEditable(true);
            weekField.setOpacity(1.0);
        } else {
            weekField.setEditable(false);
            weekField.setOpacity(0.5);
        }
    }
}

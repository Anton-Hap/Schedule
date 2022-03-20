package com.example.demo.controllers;

import com.example.demo.WindowUtils;
import com.example.demo.constants.Data;
import com.example.demo.models.Day;
import com.example.demo.utils.DayUtils;
import com.example.demo.utils.ScheduleUtils;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DemoController {

    String stylePane = "-fx-background-color: #4682B4; -fx-background-radius: 10;";

    String one = "new DropShadow(BlurType.THREE_PASS_BOX, Color.web(\"#000\"), 10, 0.0, 0, 0); new Reflection(0, 0.5, 0.5, 0);";
    String two = "new DropShadow(BlurType.THREE_PASS_BOX, Color.web(\"#000\"), 10, 0.5, 0, 0); new Reflection(0, 0.5, 0.5, 0);";
    String three = "new DropShadow(BlurType.THREE_PASS_BOX, Color.web(\"#000\"), 10, 0.0, 0, 0); new InnerShadow(BlurType.THREE_PASS_BOX, Color.web(\"#000\"), 10, 0.0, 0, 0);";

    @FXML
    private Button nextButton, menuButton, prevButton;

    @FXML
    private Label dayLabel, dateLabel;

    @FXML
    private Line line;

    @FXML
    private FlowPane pane;

    private int height = 150;

    @FXML
    void initialize() {
        Day day = ScheduleUtils.getDaySchedule(DayUtils.getNumberDay());

        dayLabel.setText(setDayName(day.getName()));
        dateLabel.setText(day.getDate());

        for (int i = 0; i < day.getLessons().size(); i++) {
            if (day.getLessons().get(i).getObjects().size() != 0) {

                updateHeightWindow(160);
                updateLine();

                AnchorPane time = new AnchorPane();
                setSettingsPane(100, 50, time);

                AnchorPane object = new AnchorPane();
                setSettingsPane(150, 100, object);

                AnchorPane teacher = new AnchorPane();
                setSettingsPane(150, 100, teacher);

                AnchorPane place = new AnchorPane();
                setSettingsPane(150, 100, place);

                Label timeLabel = new Label();
                setSettingsLabel(100, 50, timeLabel);

                Label objectLabel = new Label();
                setSettingsLabel(150, 100, objectLabel);

                Label teacherLabel = new Label();
                setSettingsLabel(150, 100, teacherLabel);

                Label placeLabel = new Label();
                setSettingsLabel(150, 100, placeLabel);

                String objectValue = "";
                String teacherValue = "";
                String placeValue = "";
                for (int j = 0; j < day.getLessons().get(i).getObjects().size(); j++) {
                    objectValue += day.getLessons().get(i).getObjects().get(j) + "\n";
                    teacherValue += day.getLessons().get(i).getTeachers().get(j) + "\n";
                    placeValue += day.getLessons().get(i).getAddress().get(j) + "\n";
                }

                timeLabel.setWrapText(true);
                objectLabel.setWrapText(true);
                teacherLabel.setWrapText(true);
                placeLabel.setWrapText(true);

                timeLabel.setText(day.getLessons().get(i).getTime());
                objectLabel.setText(objectValue);
                teacherLabel.setText(teacherValue);
                placeLabel.setText(placeValue);

                time.getChildren().add(timeLabel);
                object.getChildren().add(objectLabel);
                teacher.getChildren().add(teacherLabel);
                place.getChildren().add(placeLabel);

                pane.setAlignment(Pos.TOP_CENTER);
                pane.setHgap(5);
                pane.setVgap(50);
                pane.getChildren().addAll(time, object, teacher, place);
            }
        }

        Data.STAGE.centerOnScreen();

        nextButton.setOnAction(actionEvent -> {
            DayUtils.nextDay();
            WindowUtils.updateWindow("demo.fxml", nextButton);
        });

        prevButton.setOnAction(actionEvent -> {
            DayUtils.prevDay();
            WindowUtils.updateWindow("demo.fxml", prevButton);
        });


        menuButton.setOnAction(actionEvent -> {
            DayUtils.setNullDay();
            WindowUtils.openNewWindow("MenuWindow.fxml", menuButton);
        });
    }

    private void setSettingsLabel(double width, double height, Label label) {
        label.setMinSize(width, height);
        label.setMaxSize(width, height);
        label.setAlignment(Pos.CENTER);
        label.setWrapText(true);
        label.setTextFill(Color.web("#87CEEB"));
        label.setStyle("-fx-background-radius: 10;");
        label.setFont(Font.font("Segoe Print", FontWeight.BOLD, 13));
        DropShadow dropShadow = new DropShadow(BlurType.ONE_PASS_BOX, Color.web("#000"), 0, 0.5, 0, 0);
        dropShadow.setHeight(10);
        dropShadow.setWidth(10);
        label.setEffect(dropShadow);
    }

    private void setSettingsPane(double width, double height, Pane pane) {
        DropShadow dropShadow = new DropShadow(BlurType.THREE_PASS_BOX, Color.web("#000"), 10, 0.0, 0, 0);
        dropShadow.setInput(new Reflection(0, 0.5, 0.5, 0));

        pane.setStyle(stylePane);
        pane.setEffect(dropShadow);
        pane.setMinSize(width, height);
        pane.setMaxSize(width, height);
    }

    private void updateHeightWindow(int valueChange) {
        if (height < 1000) {
            Data.STAGE.setHeight(height);
            height += valueChange;
        }
    }

    private void updateLine() {
        line.setEndY(line.getEndY() + height);
    }

    private String setDayName(String name) {
        switch (name) {
            case "ПН":
                return "Понедельник";
            case "ВТ":
                return "Вторник";
            case "СР":
                return "Среда";
            case "ЧТ":
                return "Четверг";
            case "ПТ":
                return "Пятница";
        }

        return null;
    }
}

package com.example.demo.controllers;


import com.example.demo.models.Day;
import com.example.demo.models.Lesson;
import com.example.demo.utils.DayUtils;
import com.example.demo.utils.ScheduleUtils;
import com.example.demo.WindowUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class DayController {

    @FXML
    private Circle circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8;

    @FXML
    private AnchorPane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8;

    @FXML
    private Label time1, time2, time3, time4, time5, time6, time7, time8;

    @FXML
    private Button prevButton, nextButton, menuButton;

    @FXML
    private Label dateLabel, dayLabel;

    @FXML
    private Label object11, object21, object31, object41, object51, object61, object71, object81;

    @FXML
    private Label object12, object22, object32, object42, object52, object62, object72, object82;

    @FXML
    private Label object1, object2, object3, object4, object5, object6, object7, object8;

    @FXML
    void initialize() {
        Day day = ScheduleUtils.getDaySchedule(DayUtils.getNumberDay());

        setWrapText();

        dateLabel.setText(day.getDate());
        dayLabel.setText(setDayName(day.getName()));

        Lesson lesson = null;
        String value = "";
        int lessonIndex = 0;

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane1.setOpacity(1.0);
        } else {
            circle1.setOpacity(0.0);
            time1.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object1.setText(value);
                } else {
                    if (i == 1) {
                        object11.setText(value);
                    } else {
                        object12.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane2.setOpacity(1.0);
        } else {
            circle2.setOpacity(0.0);
            time2.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object2.setText(value);
                } else {
                    if (i == 1) {
                        object21.setText(value);
                    } else {
                        object22.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane3.setOpacity(1.0);
        } else {
            circle3.setOpacity(0.0);
            time3.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object3.setText(value);
                } else {
                    if (i == 1) {
                        object31.setText(value);
                    } else {
                        object32.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane4.setOpacity(1.0);
        } else {
            circle4.setOpacity(0.0);
            time4.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object4.setText(value);
                } else {
                    if (i == 1) {
                        object41.setText(value);
                    } else {
                        object42.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane5.setOpacity(1.0);
        } else {
            circle5.setOpacity(0.0);
            time5.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object5.setText(value);
                } else {
                    if (i == 1) {
                        object51.setText(value);
                    } else {
                        object52.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane6.setOpacity(1.0);
        } else {
            circle6.setOpacity(0.0);
            time6.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object6.setText(value);
                } else {
                    if (i == 1) {
                        object61.setText(value);
                    } else {
                        object62.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane7.setOpacity(1.0);
        } else {
            circle7.setOpacity(0.0);
            time7.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object7.setText(value);
                } else {
                    if (i == 1) {
                        object71.setText(value);
                    } else {
                        object72.setText(value);
                    }
                }
            }
        }

        lesson = day.getLessons().get(lessonIndex++);
        if (lesson.getObjects().size() == 0) {
            pane8.setOpacity(1.0);
        } else {
            circle8.setOpacity(0.0);
            time8.setText(lesson.getTime());

            for (int i = 0; i < lesson.getObjects().size(); i++) {
                value = "";
                if (lesson.getObjects().size() != 0) value += lesson.getObjects().get(i) + "\n";
                if (lesson.getTeachers().size() != 0) value += lesson.getTeachers().get(i) + "\n";
                if (lesson.getAddress().size() != 0) value += lesson.getAddress().get(i) + "\n";
                else value += "\n";

                if (lesson.getObjects().size() == 1) {
                    object8.setText(value);
                } else {
                    if (i == 1) {
                        object81.setText(value);
                    } else {
                        object82.setText(value);
                    }
                }
            }
        }

        prevButton.setOnAction(actionEvent -> {
            DayUtils.prevDay();
            WindowUtils.updateWindow("DayWindow.fxml", prevButton);
        });

        nextButton.setOnAction(actionEvent -> {
            DayUtils.nextDay();
            WindowUtils.updateWindow("DayWindow.fxml", nextButton);
        });

        menuButton.setOnAction(actionEvent -> {
            DayUtils.setNullDay();
            WindowUtils.updateWindow("MenuWindow.fxml", menuButton);
        });
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

        private void setWrapText() {
            object1.setWrapText(true);
            object11.setWrapText(true);
            object12.setWrapText(true);

            object2.setWrapText(true);
            object21.setWrapText(true);
            object22.setWrapText(true);

            object3.setWrapText(true);
            object31.setWrapText(true);
            object32.setWrapText(true);

            object4.setWrapText(true);
            object41.setWrapText(true);
            object42.setWrapText(true);

            object5.setWrapText(true);
            object51.setWrapText(true);
            object52.setWrapText(true);

            object6.setWrapText(true);
            object61.setWrapText(true);
            object62.setWrapText(true);

            object7.setWrapText(true);
            object71.setWrapText(true);
            object72.setWrapText(true);

            object8.setWrapText(true);
            object81.setWrapText(true);
            object82.setWrapText(true);
        }
}

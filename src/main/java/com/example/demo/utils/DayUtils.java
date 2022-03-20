package com.example.demo.utils;

public abstract class DayUtils {

    private static int numberDay = 0;
    private static final int MAX_DAYS = ScheduleUtils.getWeek().getDays().size();

    public static int getNumberDay() {
        return numberDay;
    }

    public static void nextDay() {
        if (numberDay < MAX_DAYS - 1) {
            numberDay++;
        }
    }

    public static void prevDay() {
        if (numberDay > 0) {
            numberDay--;
        }
    }

    public static void setNullDay() {
        numberDay = 0;
    }
}

package com.example.demo.constants;

import com.example.demo.utils.ReadConfigUtils;
import javafx.stage.Stage;

import java.util.Date;

public abstract class Data {

    public static final String LOCALDATA_PATH = ReadConfigUtils.getValue("localDataPath");
    public static final String GLOBALDATA_PATH = ReadConfigUtils.getValue("globalDataPath");
    public static final String SCHEDULE_PATH = ReadConfigUtils.getValue("schedulePath");
    public static final String URL = ReadConfigUtils.getValue("url");
    public static final String ICON_PATH = ReadConfigUtils.getValue("iconPath");

    public static String BROWSER = ReadConfigUtils.getValue("browser");

    public static Stage STAGE;
    public static final Date DATE = new Date();

    public static final String CONFIG_PATH = "src/main/resources/config.properties";

    public static void setBrowser(String browser) {
        BROWSER = browser;
    }
}

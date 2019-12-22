package ru.job4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.parsersqlru.ExecuteSqlParserJob;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class MainApp {
    private static Logger logger = LogManager.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        try (InputStream in = MainApp.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            SchedulerManager timeManager = new SchedulerManager(properties, Arrays.asList(ExecuteSqlParserJob.class));
            timeManager.handler();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

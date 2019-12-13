package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class ParseStart {
    private static Properties properties = new Properties();
    private static Logger logger = LogManager.getLogger(ParseStart.class.getName());

    public static void main(String[] args) {
        loadProperty();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail sqlJob = newJob(ExecuteParser.class)
                    .withIdentity("JS", "group1")
                    .build();

            CronTrigger cTrigger = newTrigger()
                    .withIdentity("TS", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(properties.getProperty("cron.time")))
                    .build();

            scheduler.scheduleJob(sqlJob, cTrigger);
        } catch (SchedulerException exc) {
            logger.error(exc.getMessage(), exc);
        }
    }

    private static void loadProperty() {
        try (InputStream in = ParseStart.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

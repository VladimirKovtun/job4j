package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SchedulerManager {
    private static Logger logger = LogManager.getLogger(SchedulerManager.class.getName());
    private Properties properties;
    private Class<? extends Job> execute;

    public SchedulerManager(Properties properties, Class<? extends Job> execute) {
        this.properties = properties;
        this.execute = execute;
    }

    public void handler() {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail sqlJob = newJob(execute)
                    .withIdentity("JS", "group1")
                    .build();

            sqlJob.getJobDataMap().put("properties", properties);

            CronTrigger cTrigger = newTrigger()
                    .withIdentity("TS", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule(properties.getProperty("cron.time")))
                    .build();

            scheduler.scheduleJob(sqlJob, cTrigger);
        } catch (SchedulerException exc) {
            logger.error(exc.getMessage(), exc);
        }
    }
}

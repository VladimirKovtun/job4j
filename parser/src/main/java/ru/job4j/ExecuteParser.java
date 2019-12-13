package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ExecuteParser implements Job {
    private LocalDateTime localDateTime;
    private static final Logger LOGGER = LogManager.getLogger(ExecuteParser.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("Start parsing, next start - {}", jobExecutionContext.getNextFireTime());
        ParserRepository repository = new ParserRepository(ParserDbConnection.getConnection());
        LOGGER.info("Connected successful!");
        Date prevFireTime = jobExecutionContext.getPreviousFireTime();
        if (prevFireTime == null) {
            LOGGER.info("Previous time is unknown.");
            localDateTime = repository.getLastTime();
        } else {
            localDateTime = TimeParse.dateToLocalDateTime(prevFireTime);
        }
        List<Vacancy> vacancyList = SqlParser.parseSql(localDateTime, "url");
        repository.createAll(vacancyList);
        LOGGER.info("Vacancy was added to database");
        repository.close();
    }
}

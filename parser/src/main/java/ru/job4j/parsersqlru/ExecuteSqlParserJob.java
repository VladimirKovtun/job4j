package ru.job4j.parsersqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import ru.job4j.dbconfig.ParserDbConnection;
import ru.job4j.util.TimeParse;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@DisallowConcurrentExecution
public class ExecuteSqlParserJob implements Job {
    private LocalDateTime localDateTime;
    private static final Logger LOGGER = LogManager.getLogger(ExecuteSqlParserJob.class.getName());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOGGER.info("Start parsing, next start - {}", jobExecutionContext.getNextFireTime());
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        Properties properties = (Properties) jobDataMap.get("properties");
        try (ParserSqlRuRepository repository = new ParserSqlRuRepository(ParserDbConnection.getConnection())) {
            Date prevFireTime = jobExecutionContext.getPreviousFireTime();
            if (prevFireTime == null) {
                LOGGER.info("Previous time is unknown.");
                localDateTime = repository.getLastTime();
            } else {
                LOGGER.info("Previous time and time for search {}", prevFireTime.toInstant());
                localDateTime = TimeParse.dateToLocalDateTime(prevFireTime);
            }
            List<Vacancy> vacancyList = SqlParserVacancy.parseSql(localDateTime, "url", properties);
            repository.createAll(vacancyList);
        }
    }
}

package ru.job4j.parsersqlru;

import org.junit.Test;
import ru.job4j.dbconfig.ConnectionRollback;
import ru.job4j.dbconfig.ParserDbConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParserSqlRuRepositoryTest {
    private Properties properties = new Properties();

    @Test
    public void whenAddAndGetThreeVacancies() throws SQLException, IOException {
        try (ParserSqlRuRepository repository
                     = new ParserSqlRuRepository(ConnectionRollback.create(ParserDbConnection.getConnection()));
             InputStream in = SqlParserVacancy.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            repository.createAll(SqlParserVacancy.parseSql(null, "html", properties));
            assertThat(repository.getAll().size(), is(3));
        }
    }

    @Test
    public void whenGetTime() throws SQLException {
        try (ParserSqlRuRepository repository
                     = new ParserSqlRuRepository(ConnectionRollback.create(ParserDbConnection.getConnection()))) {
            LocalDateTime localDateTime = LocalDateTime.now();
            repository.create(new Vacancy("title", "text", "link", localDateTime));
            assertThat(repository.getLastTime().withNano(0), is(localDateTime.withNano(0)));
        }
    }

}
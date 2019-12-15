package ru.job4j.parsersqlru;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlParserVacancyTest {
    private Properties properties = new Properties();

    @Test
    public void whenTryFindThreeVacancyThenTrue() throws IOException {
        try (InputStream in = SqlParserVacancy.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            List<Vacancy> result = SqlParserVacancy.parseSql(null, "html", properties);
            assertThat(result.size(), is(3));
        }

    }

}
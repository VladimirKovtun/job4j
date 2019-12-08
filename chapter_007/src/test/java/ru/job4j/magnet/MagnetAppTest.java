package ru.job4j.magnet;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MagnetAppTest {

    @Test
    public void whenGenerate10ThenSum45() {
        Config config = new Config();
        int sum = new MagnetApp(new StoreSql(config.init("url")),
                                new StoreXml(new File(config.get("pathXmlTest"))),
                                new ConvertXSQT(new File(config.get("pathXmlTest")),
                                                new File(config.get("pathXsltXmlTest")),
                                                new File(config.get("pathSchemaXsltTest"))),
                                                new File(config.get("pathXsltXmlTest")))
                                .parse(10);
        assertThat(sum, is(45));
    }

}
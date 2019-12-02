package ru.job4j.magnet;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MagnetAppTest {

    @Test
    public void whenGenerate10ThenSum45() {
        Config config = new Config();
        StoreSql storeSql = new StoreSql(config.init("url"));
        storeSql.generate(10);
        StoreXml storeXml = new StoreXml(new File(config.get("pathXmlTest")));
        storeXml.save(storeSql.load());
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(new File(config.get("pathXmlTest")),
                new File(config.get("pathXsltXmlTest")), new File(config.get("pathSchemaXsltTest")));
        MagnetApp app = new MagnetApp();
        app.saxParseToInt(new File(config.get("pathXsltXmlTest")));
        assertThat(MagnetApp.getNumber(), is(45));
    }

}
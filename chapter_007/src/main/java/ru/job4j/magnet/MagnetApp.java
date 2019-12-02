package ru.job4j.magnet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MagnetApp {
    private static int number;

    public static int getNumber() {
        return number;
    }

    public void saxParseToInt(File source) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(source, handler);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entity")) {
                number += Integer.parseInt(attributes.getValue("field"));
            }
        }
    }

    public static void main(String[] args) {
        Config config = new Config();
        StoreSql storeSql = new StoreSql(config.init("url"));
        storeSql.generate(2000000);
        StoreXml storeXml = new StoreXml(new File(config.get("pathXml")));
        storeXml.save(storeSql.load());
        ConvertXSQT convertXSQT = new ConvertXSQT();
        convertXSQT.convert(new File(config.get("pathXml")),
                new File(config.get("pathXsltXml")), new File(config.get("pathSchemaXslt")));
        new MagnetApp().saxParseToInt(new File(config.get("pathXsltXml")));
        System.out.println(getNumber());
    }
}

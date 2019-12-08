package ru.job4j.magnet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class MagnetApp {
    private static int number;
    private StoreSql storeSql;
    private StoreXml storeXml;
    private ConvertXSQT convertXSQT;
    private File source;

    public MagnetApp(StoreSql storeSql, StoreXml storeXml, ConvertXSQT convertXSQT, File source) {
        this.storeSql = storeSql;
        this.storeXml = storeXml;
        this.convertXSQT = convertXSQT;
        this.source = source;
    }

    public int parse(int generateNumber) {
        storeSql.generate(generateNumber);
        storeXml.save(storeSql.load());
        convertXSQT.convert();
        saxParseToInt();
        return getNumber();
    }

    public static int getNumber() {
        return number;
    }

    public void saxParseToInt() {
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
        int sum = new MagnetApp(new StoreSql(config.init("url")),
                                new StoreXml(new File(config.get("pathXml"))),
                                new ConvertXSQT(new File(config.get("pathXml")),
                                                new File(config.get("pathXsltXml")),
                                                new File(config.get("pathSchemaXslt"))),
                                                new File(config.get("pathXsltXml")))
                                                                    .parse(1000);
        System.out.println(sum);
    }
}

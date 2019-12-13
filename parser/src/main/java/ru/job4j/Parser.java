package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class Parser {
    protected static Logger logger = LogManager.getLogger(Parser.class.getName());

   protected static Document parse(String url) throws IOException {
       Document document;
       try {
           document = Jsoup.connect(url).get();
       } catch (IOException e) {
           logger.error(e.getMessage(), e);
           document = Jsoup.parse(url);
       }
        return document;
    }
}

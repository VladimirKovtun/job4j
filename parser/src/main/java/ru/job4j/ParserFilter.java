package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public abstract class ParserFilter {
    protected static Logger logger = LogManager.getLogger(ParserFilter.class.getName());

   protected static Document parse(String url) throws IOException {
       Document document;
       try {
           document = Jsoup.connect(url).get();
       } catch (IllegalArgumentException e) {
           String uri = url.lastIndexOf("1") == url.length() - 1 ? url.substring(0, url.length() - 1) : url;
           document = Jsoup.parse(new File(uri), "UTF-8", "");
       }
        return document;
    }
}

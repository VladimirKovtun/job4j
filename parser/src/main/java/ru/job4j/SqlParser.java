package ru.job4j;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import static ru.job4j.TimeParse.parseTime;

public class SqlParser extends Parser {
    private static Properties properties = new Properties();

    public static List<Vacancy> parseSql(LocalDateTime ldtToSearch, String var) {
        List<Vacancy> listVac = new ArrayList<>();
        loadProperty();
        String stringToParse = var.equals("url") ? properties.getProperty("url.to.parse") : var.equals("html")
                ? properties.getProperty("html.to.parse") : null;
        LocalDateTime selectTime = ldtToSearch == null ? LocalDateTime.now().minusYears(1) : ldtToSearch;
        LocalDateTime startTime = LocalDateTime.now();
        int pages = 1;
        logger.info("Start searching.");
        while (startTime.compareTo(selectTime) > 0) {
            try {
                Document sqlDoc = parse(stringToParse + pages++);
                Elements tr = sqlDoc.getElementsByTag("tr");
                for (Element trr : tr) {
                    Vacancy vacancy;
                    if (trr.childNodeSize() == 13 && trr.child(1).hasAttr("class")
                            && !trr.child(1).getElementsByTag("span").text().contains("[закрыт]")) {
                        String title = trr.child(1).child(0).text();
                        Pattern p = Pattern.compile("(?![Jj]ava\\W*[Ss]cript)([Jj]ava)");
                        if (p.matcher(title).find()) {
                            vacancy = new Vacancy();
                            String href = trr.child(1).child(0).attr("href");
                            if (connectToInnerUrl(href, vacancy, selectTime)) {
                                vacancy.setLink(href);
                                vacancy.setTitle(title);
                                listVac.add(vacancy);
                            }
                            String dateTopic = trr.child(5).text();
                            startTime = parseTime(dateTopic);
                        }
                    }
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
            if (var.equals("html")) {
                break;
            }
        }
        logger.info("Find {} vacancies.", listVac.size());
        return listVac;
    }

    private static boolean connectToInnerUrl(String url, Vacancy vacancy, LocalDateTime timeToParse) {
        boolean result = false;
        try {
            Document connect = parse(url);
            Element element = connect.getElementsByAttributeValue("class", "msgTable").get(0);
            String dateNotFormatted = element.child(0).child(2).text();
            LocalDateTime ldt = parseTime(dateNotFormatted.split("\\[")[0].trim());
            if (ldt.compareTo(timeToParse) > 0) {
                String text = element.child(0).child(1).child(1).text();
                vacancy.setMessage(text);
                vacancy.setCreateTime(ldt);
                result = true;
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    private static void loadProperty() {
        try (InputStream in = SqlParser.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
package ru.job4j.parsersqlru;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.ParserFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import static ru.job4j.util.TimeParse.parseTime;

public class SqlParserVacancy extends ParserFilter {

    public static List<Vacancy> parseSql(LocalDateTime ldtToSearch, String var, Properties properties) {
        List<Vacancy> vacancyList = new ArrayList<>();
        String stringToParse = var.equals("url") ? properties.getProperty("url.to.parse") : var.equals("html")
                                                 ? properties.getProperty("html.to.parse.test") : null;
        LocalDateTime selectTime = ldtToSearch == null ? LocalDateTime.now().minusYears(1) : ldtToSearch;
        LocalDateTime startTime = LocalDateTime.now();
        int pages = 1;
        logger.info("Start searching to {}.", selectTime);
        while (startTime.compareTo(selectTime) > 0) {
            try {
                Document sqlDoc = parse(stringToParse + pages++);
                Elements trElements = sqlDoc.getElementsByTag("tr");
                for (Element elementTr : trElements) {
                    Vacancy vacancy;
                    if (elementTr.childNodeSize() == 13 && elementTr.child(1).hasAttr("class")
                            && !elementTr.child(1).getElementsByTag("span").text().contains("[закрыт]")) {
                        String title = elementTr.child(1).child(0).text();
                        Pattern p = Pattern.compile("(?![Jj]ava\\W*[Ss]cript)([Jj]ava)");
                        if (p.matcher(title).find()) {
                            vacancy = new Vacancy();
                            String href = elementTr.child(1).child(0).attr("href");
                            if (connectToInnerUrl(href, vacancy, selectTime)) {
                                vacancy.setLink(href);
                                vacancy.setTitle(title);
                                vacancyList.add(vacancy);
                            }
                            String dateEditTopic = elementTr.child(5).text();
                            startTime = parseTime(dateEditTopic);
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
        logger.info("Find {} vacancies.", vacancyList.size());
        return vacancyList;
    }

    private static boolean connectToInnerUrl(String url, Vacancy vacancy, LocalDateTime timeForParse) {
        boolean result = false;
        try {
            Document sqlDoc = parse(url);
            Element element = sqlDoc.getElementsByAttributeValue("class", "msgTable").get(0);
            String dateBeforeFormat = element.child(0).child(2).text();
            LocalDateTime createTime = parseTime(dateBeforeFormat.split("\\[")[0].trim());
            if (createTime.compareTo(timeForParse) > 0) {
                String text = element.child(0).child(1).child(1).text();
                vacancy.setMessage(text);
                vacancy.setCreateTime(createTime);
                result = true;
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}

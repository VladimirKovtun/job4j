package ru.job4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TimeParse {
    private static Map<String, String> month = new HashMap<>();

    static {
        month.put("янв", "Jan");
        month.put("фев", "Feb");
        month.put("мар", "Mar");
        month.put("апр", "Apr");
        month.put("май", "May");
        month.put("июн", "Jun");
        month.put("июл", "Jul");
        month.put("авг", "Aug");
        month.put("сен", "Sep");
        month.put("окт", "Oct");
        month.put("ноя", "Nov");
        month.put("дек", "Dec");
    }

    public static LocalDateTime parseTime(String parseTime) {
        String beforeFormat = parseTime;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yy HH:mm", Locale.US);
        LocalDateTime localDateTime = LocalDateTime.now()
                .withHour(Integer.parseInt(beforeFormat.split(",")[1].split(":")[0].trim()))
                .withMinute(Integer.parseInt(beforeFormat.split(",")[1].split(":")[1].trim()))
                .withSecond(0);
        String[] splitByTwo = beforeFormat.split(",")[0].split(" ");
        if (splitByTwo.length == 3) {
            splitByTwo[1] = month.get(splitByTwo[1]);
            splitByTwo[0] = splitByTwo[0].length() == 1 ? "0" + splitByTwo[0] : splitByTwo[0];
            beforeFormat = String.format("%s %s %s %s", splitByTwo[0], splitByTwo[1], splitByTwo[2], beforeFormat.split(",")[1].trim());
            localDateTime = LocalDateTime.parse(beforeFormat, dtf);
        } else {
            LocalDateTime minusOne = localDateTime.minusDays(1);
            localDateTime = "вчера".equals(splitByTwo[0]) ? minusOne : localDateTime;
        }
        return localDateTime;
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


}

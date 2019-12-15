package ru.job4j.util;

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
        LocalDateTime resultTime = LocalDateTime.now()
                .withHour(Integer.parseInt(beforeFormat.split(",")[1].split(":")[0].trim()))
                .withMinute(Integer.parseInt(beforeFormat.split(",")[1].split(":")[1].trim()))
                .withSecond(0);
        String[] timeSplit = beforeFormat.split(",")[0].split(" ");
        if (timeSplit.length == 3) {
            timeSplit[1] = month.get(timeSplit[1]);
            timeSplit[0] = timeSplit[0].length() == 1 ? "0" + timeSplit[0] : timeSplit[0];
            beforeFormat = String.format("%s %s %s %s", timeSplit[0], timeSplit[1], timeSplit[2], beforeFormat.split(",")[1].trim());
            resultTime = LocalDateTime.parse(beforeFormat, dtf);
        } else {
            LocalDateTime minusOne = resultTime.minusDays(1);
            resultTime = "вчера".equals(timeSplit[0]) ? minusOne : resultTime;
        }
        return resultTime;
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }


}

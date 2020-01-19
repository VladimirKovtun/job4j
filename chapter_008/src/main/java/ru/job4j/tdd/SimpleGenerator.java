package ru.job4j.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleGenerator {
    private final Pattern keys = Pattern.compile("\\$\\{\\w*\\}");

    public String generate(String template, Map<String, String> keyValue) {
        String replaceStr = template;
        Map<String, String> tempMap = new HashMap<>(keyValue);
        Matcher matcher = keys.matcher(replaceStr);
        while (matcher.find()) {
            String group = matcher.group(0);
            String key = group.replace("${", "")
                              .replace("}", "");
            String mapKey = keyValue.get(key);
            if (mapKey == null) {
                throw new RuntimeException("Not found key!");
            } else {
                tempMap.remove(key);
            }
            replaceStr = replaceStr.replace(group, mapKey);
        }
        if (!tempMap.isEmpty()) {
            throw new IllegalStateException("Useless keys!");
        }
        return replaceStr;
    }
}

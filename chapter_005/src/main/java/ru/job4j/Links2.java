package ru.job4j;

import java.util.*;

public class Links2 {

    public Map<String, Set<String>> getLink(List<String> strOfNumbers) {
        Map<String, Set<String>> result = new HashMap<>();
        Map<String, String> temp = new HashMap<>();

        int names = 0;
        for (String strOfNumb : strOfNumbers) {
            String name = null;
            String[] str = strOfNumb.split(";");
            for (String patrOfStr : str) {
                if (temp.containsKey(patrOfStr)) {
                    name = temp.get(patrOfStr);
                    break;
                }
            }
            if (name != null) {
                result.get(name).add(strOfNumb);
            } else {
                name = String.valueOf(names++);
                result.put(name, new LinkedHashSet<>());
                result.get(name).add(strOfNumb);
            }
            for (String s : str) {
                if (s != null && !s.isEmpty() && !temp.containsKey(s)) {
                    temp.put(s, name);
                }
            }
        }
        return result;
    }
}

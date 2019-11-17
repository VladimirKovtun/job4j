package ru.job4j;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Links {

    public Map<String, Set<String>> findLink(List<String> link) {
        List<String> tempListLinks = new ArrayList<>(link);
        Set<String> setLinks;
        Map<String, Set<String>> groupMapToSet = new HashMap<>();
        Map<String, String> stringMapToGroup = new LinkedHashMap<>();
        link.forEach(k -> stringMapToGroup.put(k, null));
        int index = 0;
        for (String str : link) {
            String name = stringMapToGroup.get(str);
            if (name == null) {
                name = "group #" + index++;
                setLinks = new HashSet<>();
                setLinks.add(str);
                groupMapToSet.put(name, setLinks);
                stringMapToGroup.put(str, name);
            }
            tempListLinks.remove(str);
            for (String arr : tempListLinks) {
                /*List<String> linkStr = Arrays.asList(str.split(";"));
                List<String> linkArr = Arrays.asList(arr.split(";"));
                boolean notDisjoint = linkStr.stream().filter(x -> !x.isEmpty()).anyMatch(linkArr::contains);*/
                if (!Collections.disjoint(parse(str), parse(arr)/*notDisjoint*/)) {
                    if (stringMapToGroup.get(arr) == null) {
                        stringMapToGroup.put(arr, name);
                        setLinks = groupMapToSet.get(name);
                        setLinks.add(arr);
                        groupMapToSet.put(name, setLinks);
                    } else {
                        String oldName = name;
                        setLinks = groupMapToSet.get(oldName);
                        name = stringMapToGroup.get(arr);
                        if (setLinks.size() > 1) {
                            String finalName = name;
                            setLinks.forEach(l -> stringMapToGroup.put(l, finalName));
                        } else {
                            stringMapToGroup.put(str, name);
                        }
                        setLinks = groupMapToSet.get(name);
                        setLinks.addAll(groupMapToSet.get(oldName));
                        groupMapToSet.remove(oldName);
                        groupMapToSet.put(name, setLinks);
                    }
                }
            }
        }
        return groupMapToSet;
    }

    private List<String> parse(String string) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("^([0-9]*);([0-9]*);([0-9]*)$");
        Matcher m = pattern.matcher(string);
        if (m.matches()) {
            for (int i = 1; i < 4; i++) {
                String elReg = m.group(i);
                if (!elReg.isEmpty()) {
                    list.add(elReg);
                }
            }
        }
        return list;
    }
}

package ru.job4j.analize;

import java.util.*;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int changed = 0;
        int added = 0;
        int same = 0;
        Map<Integer, String> list = new HashMap<>();
        for (User user : previous) {
            list.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String idValue = list.get(user.getId());
            if (idValue != null && !idValue.equals(user.getName())) {
               changed++;
            } else if (idValue != null && idValue.equals(user.getName())) {
                same++;
            } else {
                added++;
            }
        }
        info.setChanged(changed);
        info.setAdded(added);
        info.setDeleted(previous.size() - same - changed);
        return info;
    }
}


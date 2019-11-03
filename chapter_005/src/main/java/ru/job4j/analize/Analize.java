package ru.job4j.analize;

import java.util.*;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int changed = 0;
        Info info = new Info();
        for (User userPrev : previous) {
            for (User userCurr : current) {
                if (userPrev.getId() == userCurr.getId() &&
                    !userPrev.getName().equals(userCurr.getName())) {
                    changed++;
                    break;
                }
            }
        }
        info.setAdded(calculate(previous, current, changed, true));
        info.setDeleted(calculate(previous, current, changed, false));
        info.setChanged(changed);
        return info;
    }

    private int calculate(List<User> prev, List<User> curr, int changed, boolean sw) {
        List<User> tempPrev = new ArrayList<>(prev);
        List<User> tempCurr = new ArrayList<>(curr);
        int res;
        if (sw) {
            tempCurr.removeAll(tempPrev);
            res = tempCurr.size() - changed;
        } else {
            tempPrev.removeAll(tempCurr);
            res = tempPrev.size() - changed;
        }
        return  res;
    }
}


package ru.job4j.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int count = 0;
        int length = o1.length() < o2.length() ? o1.length() : o2.length();
        for (int i = 0; i < length; i++) {
            count++;
            if (o1.charAt(i) < o2.charAt(i)) {
                result = -1;
                break;
            } else if (o1.charAt(i) > o2.charAt(i)) {
                result = 1;
                break;
            } else if ((count == length && o1.length() != o2.length())) {
                result = -1;
            }

        }
        return result;
    }
}

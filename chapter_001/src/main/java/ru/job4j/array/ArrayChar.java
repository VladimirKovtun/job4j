package ru.job4j.array;
/**
 * ArrayChar
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class ArrayChar {
    public static boolean startsW(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            if (word[i] != pref[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

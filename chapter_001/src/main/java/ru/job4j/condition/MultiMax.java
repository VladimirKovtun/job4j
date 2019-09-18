package ru.job4j.condition;
/**
 * MultiMax
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class MultiMax {
    public int max(int first, int second, int third) {
       int result = first > second ? first : second;
       return result > third ? result : third;
    }
}

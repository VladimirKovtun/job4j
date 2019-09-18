package ru.job4j.loop;
/**
 * Mortgage.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        while (amount > 1) {
            amount += amount * (percent / 100);
            amount -= salary;
            year++;
        }
        return year;
    }
}

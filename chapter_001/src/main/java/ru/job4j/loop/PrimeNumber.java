package ru.job4j.loop;

/**
 * PrimeNumber.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        CheckPrimeNumber checkPrime = new CheckPrimeNumber();
        for (int i = 2; i <= finish; i++) {
            if (checkPrime.check(i)) {
                count++;
            }
        }
        return count;
    }
}

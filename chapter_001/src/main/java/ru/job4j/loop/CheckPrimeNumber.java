package ru.job4j.loop;
/**
 * CheckPrimeNumber.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class CheckPrimeNumber {
    public boolean check(int finish) {
        boolean prime = true;
        for (int i = 2; i < finish; i++) {
            if (finish % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}

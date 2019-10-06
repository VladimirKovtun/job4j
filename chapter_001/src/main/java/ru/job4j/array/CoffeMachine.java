package ru.job4j.array;

import java.util.Arrays;


public class CoffeMachine {

    public static int[] changes(int value, int price) {
        int change = value - price;
        if (change == 0) {
            return new int[]{0};
        }
        if (change < 0) {
            return new int[]{-1};
        }
        int array = change % 10 == 0 ? change / 10 :
                (change % 10) % 5 == 0 ? (change / 10) + 1 :
                        (change / 5) < 3 ? (change / 10) + 2 : (change / 10) + 3;
        int[] coins = new int[array];
        int index = 0;
        while (change > 0) {
            if (change >= 10) {
                coins[index++] = 10;
                change -= 10;
            } else if (change >= 5) {
                coins[index++] = 5;
                change -= 5;
            } else if (change >= 2) {
                coins[index++] = 2;
                change -= 2;
            } else {
                coins[index++] = 1;
                change -= 1;
            }
        }

        return coins;
    }
}


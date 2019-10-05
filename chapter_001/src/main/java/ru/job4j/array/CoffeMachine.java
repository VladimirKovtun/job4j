package ru.job4j.array;

import java.util.Arrays;


public class CoffeMachine {

    public static int[] changes(int value, int price) {
        int change = value - price;
        if (change == 0) {
            return new int[]{0};
        }
        if (change < 0){
            return new int[]{-1};
        }
        int array = change % 5 == 0 ? change / 5 :
                    change % 5 < 3 ? (change / 5) + 1 : (change / 5) + 2;
        int[] oddMoney = new int[array];
        int index = 0;
        while (change > 0) {
             if (change % 5 == 1 || change % 5 == 3){
                oddMoney[index++] = 1;
                change -= 1;
             } else if (change % 5 == 2 || change % 5 == 4) {
                 oddMoney[index++] = 2;
                 change -= 2;
             } else {
                 oddMoney[index++] = 5;
                 change -= 5;
             }
         }

        return oddMoney;
    }
}


package ru.job4j.array;

import java.util.Arrays;

public class CoffeMachine {

    public static int[] changes(int value, int price) {
        int change = value - price;
        int[] oddMoney;
        if (change < 0) {
            System.out.println("Денег не достаточно!");
            oddMoney = new int[0];
        } else if (change % 5 == 0) {
            oddMoney = new int[change / 5];
            Arrays.fill(oddMoney, 5);
        } else if (change % 5 < 3) {
            oddMoney = new int[(change / 5) + 1];
            Arrays.fill(oddMoney, 1, oddMoney.length, 5);
            if (change % 5 == 1) {
                Arrays.fill(oddMoney, 0, 1, 1);
            } else {
                Arrays.fill(oddMoney, 0, 1, 2);
            }
        } else {
            oddMoney = new int[(change / 5) + 2];
            Arrays.fill(oddMoney, 2, oddMoney.length, 5);
            if (change % 5 == 3) {
                Arrays.fill(oddMoney, 0, 1, 1);
                Arrays.fill(oddMoney, 1, 2, 2);
            } else {
                Arrays.fill(oddMoney, 0, 2, 2);
            }
        }
        return oddMoney;
    }

    public static void main(String[] args) {
        int[] changes = CoffeMachine.changes(7, 35);
        System.out.println(Arrays.toString(changes));
    }
}


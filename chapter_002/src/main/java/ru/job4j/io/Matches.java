package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int input;
        System.out.println("На столе лежит 11 спичек.\n"
                           + "Вы можете взять от 1 до 3 спичек. Выиграет тот кто возьмет последние");
        while (sum < 11) {
            count++;
            System.out.printf("На столе осталось %d спичек.%n", 11 - sum);
            while (!(((input = scanner.nextInt()) < 4) && input > 0)) {
                System.out.println("Введите корректные данные.");
            }
            sum += input;
        }
        System.out.println(count % 2 != 0 ? "Player 1 is WINNER!!!" : "Player 2 is WINNER!!!");
    }
}

package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Я великий оракул. Что хочешь узнать?");
        String question = scanner.nextLine();
        int rnd = random.nextInt(3);
        if (rnd == 0) {
            System.out.println("Да!");
        } else if (rnd == 1) {
            System.out.println("Нет!");
        } else {
            System.out.println("Может быть...");
        }
    }
}

package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(" ______\n")
                            .append("|      |\n")
                            .append("|      |\n")
                            .append("|______|\n")
                            .toString();
    }
}

package ru.job4j.strategy;

public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("   /\\\n")
                            .append("  /  \\\n")
                            .append(" /    \\\n")
                            .append("/______\\\n")
                            .toString();
    }
}

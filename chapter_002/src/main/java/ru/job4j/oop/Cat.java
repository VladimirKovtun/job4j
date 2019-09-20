package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void giveNick(String nick) {
        name = nick;
    }

    public void eat(String meat) {
        food = meat;
    }

    public void show() {
        System.out.printf("There are %s's %s %n", this.name, this.food);
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("chop");
        gav.show();
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

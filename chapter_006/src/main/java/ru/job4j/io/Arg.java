package ru.job4j.io;

public class Arg {
    private final String args;

    public Arg(String args) {
        this.args = args;
    }

    public String directory() {
        return args.split("-d")[1].trim().split(" ")[0];
    }

    public String exclude() {
        return args.split("-e")[1].trim().split(" ")[0];
    }

    public String output() {
        return args.split("-o")[1].trim().split(" ")[0];
    }
}

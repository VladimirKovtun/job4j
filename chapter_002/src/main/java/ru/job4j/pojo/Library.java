package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] books = {new Book("Head First Java", 720),
                new Book("Clean Code", 464),
                new Book("Effective Java", 412),
                new Book("Head First Design Patterns", 694)};

        for (int index = 0; index < books.length; index++) {
            System.out.printf("%s - %d pages%n", books[index].getTitle(), books[index].getPageCount());
        }
        System.out.println("");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int index = 0; index < books.length; index++) {
            System.out.printf("%s - %d pages%n", books[index].getTitle(), books[index].getPageCount());
        }
        System.out.println("");
        for (int index = 0; index < books.length; index++) {
            if (books[index].getTitle().equals("Clean Code")) {
                System.out.printf("%s - %d pages%n", books[index].getTitle(), books[index].getPageCount());
            }
        }

    }
}

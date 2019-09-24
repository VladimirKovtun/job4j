package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean isExit = false;
        while (!isExit) {
            this.showMenu();
            System.out.println("Select: ");
            int select = scanner.nextInt();
            if (select == 0) {
                System.out.println("**Add new item**");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("**Show all items**");
                Item[] allItems = tracker.findAll();
                for (Item item : allItems) {
                    System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
                }
            } else if (select == 2) {
                System.out.println("**Edit item**");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter ID item: ");
                String id = String.valueOf(scanner.nextLong());
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item replace.");
                } else {
                    System.out.println("Item not replace.");
                }
            } else if (select == 3) {
                System.out.println("**Delete item**");
                System.out.println("Enter ID item which be delete: ");
                String id = String.valueOf(scanner.nextLong());
                if (tracker.delete(id)) {
                    System.out.println("Item delete.");
                } else {
                    System.out.println("Item not delete");
                }
            } else if (select == 4) {
                System.out.println("**Find item by ID**");
                System.out.println("Enter ID item: ");
                String id = String.valueOf(scanner.nextLong());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
                } else {
                    System.out.println("Null.");
                }

            } else if (select == 5) {
                System.out.println("**Find items by name**");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] byName = tracker.findByName(name);
                if (byName != null) {
                    for (Item item : byName) {
                        System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
                    }
                } else {
                    System.out.println("Null.");
                }
            } else if (select == 6) {
                System.out.println("The program will be closed...");
                isExit = true;
            } else {
                System.out.println("Incorrect data entered.\n" + "Retype please.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu input:\n"
                           + "1. Add new item.\n"
                           + "2. Delete item.\n"
                           + "3. Edit item.\n"
                           + "4. Find item by id.\n"
                           + "5. Find items by name.\n"
                           + "6. Exit Programm.");
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.init(new Scanner(System.in), new Tracker());
    }
}

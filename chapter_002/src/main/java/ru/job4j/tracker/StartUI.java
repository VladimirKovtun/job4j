package ru.job4j.tracker;


public class StartUI {


    public void init(Input input, Tracker tracker) {
        boolean isExit = false;
        while (!isExit) {
            this.showMenu();
            System.out.println("Select: ");
            int select = (int) input.askLong("");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showItems(tracker);
            } else if (select == 2) {
               editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findById(input, tracker);
            } else if (select == 5) {
                findByName(input, tracker);
            } else if (select == 6) {
                System.out.println("The program will be closed...");
                isExit = true;
            } else {
                System.out.println("Incorrect data entered.\nRetype please.");
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        String name = input.askStr("**Add new item**\nEnter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Tracker tracker) {
        System.out.println("**Show all items**");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        String name = input.askStr("**Edit item**\nEnter name: ");
        String id = String.valueOf(input.askLong("Enter ID item: "));
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replace.");
        } else {
            System.out.println("Item not replace.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        String id = String.valueOf(input.askLong("**Delete item**\nEnter ID item which be delete: "));
        if (tracker.delete(id)) {
            System.out.println("Item delete.");
        } else {
            System.out.println("Item not delete");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        String id = String.valueOf(input.askLong("**Find item by ID**\nEnter ID item: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
        } else {
            System.out.println("Null.");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("**Find items by name**\nEnter name: ");
        Item[] byName = tracker.findByName(name);
        if (byName != null) {
            for (Item item : byName) {
                System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
            }
        } else {
            System.out.println("Null.");
        }
    }

    private void showMenu() {
        System.out.println("Menu input:\n"
                           + "0. Add new item.\n"
                           + "1. Show all items.\n"
                           + "2. Delete item.\n"
                           + "3. Edit item.\n"
                           + "4. Find item by id.\n"
                           + "5. Find items by name.\n"
                           + "6. Exit Program.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        StartUI startUI = new StartUI();
        startUI.init(input, new Tracker());
    }
}

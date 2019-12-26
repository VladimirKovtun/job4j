package ru.job4j.isp;

import java.util.*;

public class Menu implements IMenu<CurrItem> {
    private List<CurrItem> itemList = new LinkedList<>();

    public void showMenu() {
        Deque<CurrItem> queue = new LinkedList<>(itemList);
        while (!queue.isEmpty()) {
            CurrItem poll = queue.poll();
            List<CurrItem> items = poll.show();
            if (items != null && !items.isEmpty()) {
                Collections.reverse(items);
                items.forEach(queue::offerFirst);
            }
        }
    }

    @Override
    public void add(List<CurrItem> list) {
        this.itemList = list;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add(Arrays.asList(new CurrItem("Задача 1", Arrays.asList(
                new CurrItem("---Задача 1.1", Arrays.asList(
                        new CurrItem("------Задача 1.1.1", null),
                        new CurrItem("------Задача 1.1.2", null)
                )),
                new CurrItem("---Задача 1.2", null)
                )),
                new CurrItem("Задача 2", null)));
        menu.showMenu();
    }
}

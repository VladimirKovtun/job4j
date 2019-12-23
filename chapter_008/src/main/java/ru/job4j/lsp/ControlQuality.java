package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {
    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void control(Food food) {
        for (Store store : storeList) {
            if (store.checkProduct(food)) {
                store.add(food);
                break;
            }
        }
    }
}

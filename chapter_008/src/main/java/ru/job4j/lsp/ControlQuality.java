package ru.job4j.lsp;

import ru.job4j.dip.Sortable;

import java.util.List;

public class ControlQuality implements Sortable {
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

    @Override
    public void resort() {
        for (Store str : storeList) {
            str.getFoodList().forEach(this::control);
        }
    }
}

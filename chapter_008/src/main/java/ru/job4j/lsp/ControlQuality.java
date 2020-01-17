package ru.job4j.lsp;

import ru.job4j.dip.Sortable;

import java.util.ArrayList;
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
        List<Food> temp = new ArrayList<>();
        for (Store str : storeList) {
           temp.addAll(str.getFoodList());
           str.getFoodList().clear();
        }
        temp.forEach(this::control);
    }
}

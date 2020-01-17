package ru.job4j.lsp;

import java.util.*;

public abstract class Store {
    private Set<Food> foodList;

    public Store() {
        this.foodList = new HashSet<>();
    }

    abstract boolean checkProduct(Food food);

    protected int isTime(Date createDate, Date expireDate) {
        long l = expireDate.getTime() - createDate.getTime();
        long l1 = expireDate.getTime() - System.currentTimeMillis();
        return Math.round(l1 * 100 / l);
    }

    protected void add(Food food) {
        foodList.add(food);
    }

    public Set<Food> getFoodList() {
        return foodList;
    }
}

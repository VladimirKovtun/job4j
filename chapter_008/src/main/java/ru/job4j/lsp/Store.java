package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Store {
    private List<Food> foodList;

    public Store() {
        this.foodList = new ArrayList<>();
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

    public List<Food> getFoodList() {
        return foodList;
    }
}

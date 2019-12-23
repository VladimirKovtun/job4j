package ru.job4j.lsp;


public class Warehouse extends Store {

    @Override
    boolean checkProduct(Food food) {
        return isTime(food.getCreateDate(), food.getExpireDate()) > 75;
    }
}


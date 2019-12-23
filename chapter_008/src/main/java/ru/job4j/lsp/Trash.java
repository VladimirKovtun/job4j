package ru.job4j.lsp;


public class Trash extends Store {

    @Override
    boolean checkProduct(Food food) {
        return isTime(food.getCreateDate(), food.getExpireDate()) < 1;
    }
}

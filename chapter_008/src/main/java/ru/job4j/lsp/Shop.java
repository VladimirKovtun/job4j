package ru.job4j.lsp;


public class Shop extends Store {

    @Override
    boolean checkProduct(Food food) {
        int result = isTime(food.getCreateDate(), food.getExpireDate());
        return result > 0 && result <= 75;
    }

    public void add(Food food) {
        if (isTime(food.getCreateDate(), food.getExpireDate()) < 25) {
            food.setDiscount(50);
        }
        super.add(food);
    }
}

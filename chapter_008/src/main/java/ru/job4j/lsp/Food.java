package ru.job4j.lsp;

import java.util.Date;
import java.util.Objects;

public class Food {
    private String name;
    private Date expireDate;
    private Date createDate;
    private int price;
    private int discount;

    public Food(String name, Date expireDate, Date createDate, int price, int discount) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return price == food.price
                && discount == food.discount
                && name.equals(food.name)
                && expireDate.equals(food.expireDate)
                && createDate.equals(food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expireDate, createDate, price, discount);
    }
}

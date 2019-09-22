package ru.job4j.pojo;


public class Shop {

    public Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index; i < products.length - 2; i++) {
            if (products[i] == null && products[i + 1] != null) {
                products[i] = products[i + 1];
                products[i + 1] = null;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = {new Product("Milk", 10),
                              new Product("Bread", 4),
                              new Product("Egg", 19),
                              null,
                              null};
        Shop shop = new Shop();
        Product[] delete = shop.delete(products, 1);
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName() + " " + products[i].getCount());
            } else {
                System.out.println("null");
            }
        }
    }
}

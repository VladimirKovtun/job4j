package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private Trash trash;
    private Shop shop;
    private Warehouse warehouse;
    private ControlQuality contr;

    @Before
    public void init() {
        warehouse = new Warehouse();
        trash = new Trash();
        shop = new Shop();
        contr = new ControlQuality(Arrays.asList(warehouse, trash, shop));
    }

    @Test
    public void whenAddFoodWithExpDateThenTrash() {
        List<Food> list = Arrays.asList(new Food("White bread", new Date(1577135594000L), new Date(1576865453000L), 32, 0));

        for (Food food : list) {
            contr.control(food);
        }
        assertThat(trash.getFoodList().get(0).getName(), is("White bread"));
    }

    @Test
    public void whenAddFoodWithNewDateThenWarehouse() {
        List<Food> list = Arrays.asList(new Food("Coca - Cola", new Date(1592222253000L), new Date(1574273453000L), 55, 0));
        for (Food food : list) {
            contr.control(food);
        }
        assertThat(warehouse.getFoodList().get(0).getName(), is("Coca - Cola"));
    }

    @Test
    public void whenAddFoodWithDateLess25PercentThenShopAndDiscount() {
        List<Food> list = Arrays.asList(new Food("Chocolate Babaevskiy", new Date(1577470253000L), new Date(1574273453000L), 70, 0));
        for (Food food : list) {
            contr.control(food);
        }
        assertThat(shop.getFoodList().get(0).getName(), is("Chocolate Babaevskiy"));
        assertThat(shop.getFoodList().get(0).getDiscount(), is(50));
    }

    @Test
    public void whenAddFoodWithDateMore25AndLess75PercentThenShop() {
        List<Food> list = Arrays.asList(new Food("Chocolate Alyonka", new Date(1582222253000L), new Date(1574273453000L), 70, 0));
        for (Food food : list) {
            contr.control(food);
        }
        assertThat(shop.getFoodList().get(0).getName(), is("Chocolate Alyonka"));
    }
}
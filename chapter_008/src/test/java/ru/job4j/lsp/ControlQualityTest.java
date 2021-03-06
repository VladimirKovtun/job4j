package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
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
        assertThat(trash.getFoodList().iterator().next().getName(), is("White bread"));
    }

    @Test
    public void whenAddFoodWithNewDateThenWarehouse() {
        List<Food> list = Arrays.asList(new Food("Coca - Cola", new Date(1612222253000L), new Date(1574273453000L), 55, 0));
        for (Food food : list) {
            contr.control(food);
        }
        assertThat(warehouse.getFoodList().iterator().next().getName(), is("Coca - Cola"));
    }

    @Test
    public void whenAddFoodWithDateLess25PercentThenShopAndDiscount() {
        List<Food> list = Arrays.asList(new Food("Chocolate Babaevskiy", new Date(new Date().getTime() + 86400000L), new Date(new Date().getTime() - 345600000L), 70, 0));
        for (Food food : list) {
            contr.control(food);
        }
        Food food = shop.getFoodList().iterator().next();
        assertThat(food.getName(), is("Chocolate Babaevskiy"));
        assertThat(food.getDiscount(), is(50));
    }

    @Test
    public void whenAddFoodWithDateMore25AndLess75PercentThenShop() {
        List<Food> list = Arrays.asList(new Food("Chocolate Alyonka", new Date(1582222253000L), new Date(1574273453000L), 70, 0));
        for (Food food : list) {
            contr.control(food);
        }
        assertThat(shop.getFoodList().iterator().next().getName(), is("Chocolate Alyonka"));
    }

    @Test
    public void whenInShopAndWarehouseFoodWithExpiredDateThenAfterResortBothInTrash() {
        shop.add(new Food("White bread", new Date(1577135594000L), new Date(1576865453000L), 32, 0));
        warehouse.add(new Food("Chocolate Babaevskiy", new Date(1577470253000L), new Date(1574273453000L), 70, 0));
        contr.resort();
        Iterator<Food> foodIterator = trash.getFoodList().iterator();
        assertThat(foodIterator.next().getName(), is("White bread"));
        assertThat(foodIterator.next().getName(), is("Chocolate Babaevskiy"));
        assertTrue(shop.getFoodList().isEmpty());
        assertTrue(warehouse.getFoodList().isEmpty());
    }
}
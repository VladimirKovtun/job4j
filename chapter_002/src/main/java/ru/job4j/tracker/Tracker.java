package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (item != null && id != null && id.equals(this.items[i].getId())) {
                item.setId(id);
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                this.items[i] = null;
                this.position --;
                System.arraycopy(this.items,i + 1, this.items, i, this.items.length - i - 1);
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];;
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (key != null && this.items[i] != null && key.equals(this.items[i].getName())) {
                  result[count++] = this.items[i];
            }
        }
        return count == 0 ? null : Arrays.copyOfRange(result,0, count);
    }

    public Item findById(String id) {
        Item resultItem = null;
        for (int i = 0; i < this.position; i++) {
            if (id != null && this.items[i] != null && id.equals(this.items[i].getId())) {
                resultItem = this.items[i];
                break;
            }
        }
        return resultItem;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}

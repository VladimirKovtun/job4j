package ru.job4j.tracker.sigleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingletonFour {
    private static Tracker tracker = new Tracker();

    private TrackerSingletonFour() {

    }

    public static TrackerSingletonFour getInstance() {
        return Holder.instance;
    }


    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }

    private static final class Holder {
        private static final TrackerSingletonFour instance = new TrackerSingletonFour();
    }
}

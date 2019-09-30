package ru.job4j.tracker.sigleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingletonThree {
    private static TrackerSingletonThree instance = new TrackerSingletonThree();
    private static Tracker tracker = new Tracker();

    private TrackerSingletonThree() {

    }

    public static TrackerSingletonThree getInstance() {
        return instance;
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
}


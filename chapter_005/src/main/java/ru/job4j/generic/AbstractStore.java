package ru.job4j.generic;

import java.util.Iterator;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> array;

    public AbstractStore(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rst = false;
        int count = 0;
        for (Iterator<T> it = array.iterator(); it.hasNext();) {
            T el = it.next();
            if (el.getId().equals(id)) {
                array.set(count, model);
                rst = true;
            }
            count++;
        }
        return rst;
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        int count = 0;
        for (Iterator<T> it = array.iterator(); it.hasNext();) {
            T el = it.next();
            if (el.getId().equals(id)) {
                array.remove(count);
                rst = true;
            }
            count++;
        }
        return rst;
    }

    @Override
    public T findById(String id) {
        T elem = null;
        int count = 0;
        for (Iterator<T> it = array.iterator(); it.hasNext();) {
            T el = it.next();
            if (el.getId().equals(id)) {
                elem = array.get(count);
            }
            count++;
        }
        return elem;
    }
}

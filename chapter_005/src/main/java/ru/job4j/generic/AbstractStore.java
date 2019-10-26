package ru.job4j.generic;

import java.util.Iterator;

public abstract class AbstractStore <T extends Base> implements Store<T> {
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
        for (Iterator<T> it = array.iterator(); it.hasNext(); ) {
            T el = it.next();
            if (el.getId().equals(id)) {
                array.set(array.getPosition(el), model);
                rst = true;
            }
        }
        return rst;
    }

    @Override
    public boolean delete(String id) {
        boolean rst = false;
        for (Iterator<T> it = array.iterator(); it.hasNext(); ) {
            T el = it.next();
            if (el.getId().equals(id)) {
                array.remove(array.getPosition(el));
                rst = true;
            }
        }
        return rst;
    }

    @Override
    public T findById(String id) {
        T elem = null;
        for (Iterator<T> it = array.iterator(); it.hasNext(); ) {
            T el = it.next();
            if (el.getId().equals(id)) {
                elem = array.get(array.getPosition(el));
            }
        }
        return elem;
    }
}

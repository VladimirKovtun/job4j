package ru.job4j.generic;

import java.util.Iterator;

public class UserStore extends AbstractStore<User> {

    public UserStore(SimpleArray<User> array) {
        super(array);
    }


    /*@Override
    public void add(User model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean rst = false;
        for (Iterator<User> it = array.iterator(); it.hasNext(); ) {
            User el = it.next();
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
        for (Iterator<User> it = array.iterator(); it.hasNext(); ) {
            User el = it.next();
            if (el.getId().equals(id)) {
                array.remove(array.getPosition(el));
                rst = true;
            }
        }
        return rst;
    }

    @Override
    public User findById(String id) {
        User elem = null;
        for (Iterator<User> it = array.iterator(); it.hasNext(); ) {
            User el = it.next();
            if (el.getId().equals(id)) {
                elem = array.get(array.getPosition(el));
            }
        }
        return elem;
    }*/
}


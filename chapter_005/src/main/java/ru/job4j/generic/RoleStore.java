package ru.job4j.generic;

import java.util.Iterator;

public class RoleStore extends AbstractStore<Role> {

    public RoleStore(SimpleArray<Role> array) {
        super(array);
    }

    /*@Override
    public void add(Role model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean rst = false;
        for (Iterator<Role> it = array.iterator(); it.hasNext(); ) {
            Role el = it.next();
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
        for (Iterator<Role> it = array.iterator(); it.hasNext(); ) {
            Role el = it.next();
            if (el.getId().equals(id)) {
                array.remove(array.getPosition(el));
                rst = true;
            }
        }
        return rst;
    }

    @Override
    public Role findById(String id) {
        Role elem = null;
        for (Iterator<Role> it = array.iterator(); it.hasNext(); ) {
            Role el = it.next();
            if (el.getId().equals(id)) {
                elem = array.get(array.getPosition(el));
            }
        }
        return elem;
    }*/
}

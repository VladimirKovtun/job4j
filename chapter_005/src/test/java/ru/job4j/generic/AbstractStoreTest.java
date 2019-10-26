package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AbstractStoreTest {

    @Test
    public void whenAddedFile() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(1));
        User user = new User("a");
        store.add(user);
        assertThat(store.findById("a"), is(user));
    }

    @Test
    public void whenElementExistThenReplaceTrue() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(1));
        User user = new User("a");
        User newUser = new User("b");
        store.add(user);
        boolean result = store.replace("a", newUser);
        assertTrue(result);
    }

    @Test
    public void whenElementNotExistThenReplaceFalse() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(1));
        User user = new User("a");
        User newUser = new User("b");
        store.add(user);
        boolean result = store.replace("c", newUser);
        assertFalse(result);
    }

    @Test
    public void whenFindById() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(3));
        User user = new User("a");
        User newUser = new User("b");
        User againNewUser = new User("c");
        store.add(user);
        store.add(newUser);
        store.add(againNewUser);
        assertThat(store.findById("b"), is(newUser));
    }

    @Test
    public void whenRemovedExistElementThenTrue() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(2));
        User user = new User("a");
        User newUser = new User("b");
        store.add(user);
        store.add(newUser);
        boolean result = store.delete("a");
        assertTrue(result);
    }

    @Test
    public void whenRemovedNotExistElementThenFalse() {
        AbstractStore<User> store = new UserStore(new SimpleArray<>(1));
        User user = new User("a");
        store.add(user);
        boolean result = store.delete("b");
        assertFalse(result);
    }

}
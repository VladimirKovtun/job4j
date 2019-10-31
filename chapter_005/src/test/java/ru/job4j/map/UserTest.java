package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenEqualsNotOverrideThenSamePersonShouldPutInMap() {
        Map<User, Object> users = new HashMap<>();
        User user1 = new User("Ivan", 1, new GregorianCalendar(2000, Calendar.JANUARY, 25));
        User user2 = new User("Ivan", 1, new GregorianCalendar(2000, Calendar.JANUARY, 25));
        users.put(user1, new Object());
        users.put(user2, new Object());
        System.out.println(users);
        assertThat(user1.equals(user2), is(false));
    }

}
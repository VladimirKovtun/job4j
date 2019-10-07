package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenSort() {
        User vadim = new User("Vadim", 15);
        User almaz = new User("Almaz", 15);
        User xandr = new User("Xandr", 33);
        User alex = new User("Alex", 33);
        User ivan = new User("Ivan", 25);
        List<User> users = Arrays.asList(vadim, almaz, xandr, alex, ivan);

        TreeSet<User> result = new SortUser().sort(users);
        assertThat(result, Is.is(Arrays.asList(almaz, vadim, ivan, alex, xandr)));
    }

}
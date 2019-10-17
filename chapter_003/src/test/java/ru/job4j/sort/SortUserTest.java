package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void whenSortByAge() {
        Set<User> result = new SortUser().sort(List.of(
                new User("Vadim", 15),
                new User("Almaz", 23),
                new User("Xandr", 12),
                new User("Alex", 33),
                new User("Ivan", 25)
        ));
        assertThat(result.toString(), Is.is(List.of(
                new User("Xandr", 12),
                new User("Vadim", 15),
                new User("Almaz", 23),
                new User("Ivan", 25),
                new User("Alex", 33)
                ).toString()));
    }

    @Test
    public void whenSortByNameLength() {
        List<User> result = new SortUser().sortNameLength(Arrays.asList(
                             new User("Max", 15),
                             new User("Konstantin", 15),
                             new User("Xandr", 33),
                             new User("Alex", 33),
                             new User("Oz", 25)
        ));
        assertThat(result, Is.is(Arrays.asList(
                            new User("Oz", 25),
                            new User("Max", 15),
                            new User("Alex", 33),
                            new User("Xandr", 33),
                            new User("Konstantin", 15)
                            )));
    }

    @Test
    public void whenSortByAllFields() {
        List<User> result = new SortUser().sortByAllFields(Arrays.asList(
                new User("Vadim", 15),
                new User("Almaz", 15),
                new User("Xandr", 33),
                new User("Alex", 33),
                new User("Alex", 25)
        ));
        assertThat(result.toString(), Is.is(Arrays.asList(
                new User("Alex", 25),
                new User("Alex", 33),
                new User("Almaz", 15),
                new User("Vadim", 15),
                new User("Xandr", 33
                )).toString()));
    }
}
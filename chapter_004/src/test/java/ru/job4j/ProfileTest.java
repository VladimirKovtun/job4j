package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void whenListAddress() {
        List<Address> result = Profile.collect(Arrays.asList(
                               new Profile(new Address("Kazan", "Lenina", 2, 12)),
                               new Profile(new Address("Moscow", "Pushkina", 23, 434))));
        assertThat(result.get(0).getHome(), Is.is(2));
    }

    @Test
    public void whenSortListAddress() {
        List<Address> result = Profile.collectNew(Arrays.asList(
                new Profile(new Address("Moscow", "Pushkina", 23, 434)),
                new Profile(new Address("Kazan", "Lenina", 2, 12)),
                new Profile(new Address("Moscow", "Pushkina", 23, 434)),
                new Profile(new Address("Bishkek", "Ordjonikidze", 25, 43))));
        assertThat(result.toString(), Is.is(Arrays.asList(
                            new Address("Bishkek", "Ordjonikidze", 25, 43),
                            new Address("Kazan", "Lenina", 2, 12),
                            new Address("Moscow", "Pushkina", 23, 434)).toString()));
    }

}
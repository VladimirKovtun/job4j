package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void when() {
        List<Address> result = Profile.collect(Arrays.asList(
                               new Profile(new Address("Kazan", "Lenina", 2, 12)),
                               new Profile(new Address("Moscow", "Pushkina", 23, 434))));
        assertThat(result.get(0).getHome(), Is.is(2));
    }

}
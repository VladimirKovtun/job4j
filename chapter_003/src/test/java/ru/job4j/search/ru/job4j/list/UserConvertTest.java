package ru.job4j.search.ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void whenListToMap() {
        User user1 = new User("Vova", "Saint-Petersburg");
        User user2 = new User("Vadim", "Moscow");
        HashMap<Integer, User> result = new UserConvert().process(new ArrayList<>(Arrays.asList(user1, user2)));
        assertThat(result.get(user1.getId()).getName(), Is.is("Vova"));
    }

}
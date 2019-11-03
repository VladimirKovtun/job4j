package ru.job4j.analize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAdd0Change1Delete1() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(0, "Ivan"),
                                         new User(1, "Dima"), new User(2, "Alex"))),
                                         new ArrayList<>(Arrays.asList(new User(2, "Alex"),
                                         new User(1, "Vadim"))));
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getDeleted(), is(1));
    }

    @Test
    public void whenAdd0Change0Delete3() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(0, "Ivan"),
                new User(1, "Dima"), new User(2, "Alex"))),
                new ArrayList<>());
        assertThat(result.getAdded(), is(0));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(3));
    }

    @Test
    public void whenAdd2Change0Delete0() {
        Info result = new Analize().diff(new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new User(2, "Alex"),
                        new User(1, "Vadim"))));
        assertThat(result.getAdded(), is(2));
        assertThat(result.getChanged(), is(0));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenAdd1Change1Delete0() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(2, "Alex"))),
                new ArrayList<>(Arrays.asList(new User(1, "Alex"),
                        new User(2, "Vadim"))));
        assertThat(result.getAdded(), is(1));
        assertThat(result.getChanged(), is(1));
        assertThat(result.getDeleted(), is(0));
    }

    @Test
    public void whenAdd3Change2Delete1() {
        Info result = new Analize().diff(new ArrayList<>(Arrays.asList(new User(0, "Ivan"),
                new User(1, "Dima"), new User(2, "Alex"),
                new User(3, "Anton"))),
                new ArrayList<>(Arrays.asList(new User(2, "Alex"), new User(3, "Nik"),
                        new User(1, "Vadim"), new User(5, "Gleb"), new User(7, "Dasha"),
                         new User(8, "Olya"))));
        assertThat(result.getAdded(), is(3));
        assertThat(result.getChanged(), is(2));
        assertThat(result.getDeleted(), is(1));
    }
}
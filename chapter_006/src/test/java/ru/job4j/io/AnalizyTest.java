package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void when() {
        String source = "./data/server";
        String target = "./data/unavailable.csv";
        new Analizy().unAvailable(source, target);
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
                assertThat(reader.readLine(), is("10:58:01;10:59:01;"));
                assertThat(reader.readLine(), is("11:01:02;11:02:02;"));
        }catch (IOException exc) {
        }
    }

}
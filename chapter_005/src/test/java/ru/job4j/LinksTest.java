package ru.job4j;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinksTest {

    @Test
    public void whenThreeStringAndOneGroup() {
        Map<String, Set<String>> link = new Links().findLink(List.of("111;123;222", "200;123;100", "300;;100"));
        assertThat(link.size(), is(1));
    }

    @Test
    public void whenTenStringAndTwoGroup() {
        Map<String, Set<String>> link = new Links().findLink(List.of("111;123;222"
                                                                    , "23;155;678"
                                                                    , "200;123;100"
                                                                    , "300;;100"
                                                                    , "223;190;54"
                                                                    , "125;156;12"
                                                                    , "156;211;"
                                                                    , "212;300;10"
                                                                    , ";12;231"
                                                                    , "223;125;23"));
        assertThat(link.size(), is(2));
    }
}
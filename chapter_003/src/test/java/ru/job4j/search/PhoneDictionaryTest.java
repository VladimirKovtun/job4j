package ru.job4j.search;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phoneBook = new PhoneDictionary();
        phoneBook.add(new Person("Vladimir", "Kovtun", "1234567", "Saint-Petersburg"));
        var people = phoneBook.find("dim");
        Assert.assertThat(people.iterator().next().getPhone(), Is.is("1234567"));
    }

    @Test
    public void whenFindTwoPeopleByName() {
        var phoneBook = new PhoneDictionary();
        phoneBook.add(new Person("Vladimir", "Kovtun", "1234567", "Saint-Petersburg"));
        phoneBook.add(new Person("Nurlan", "Bay", "322", "Nur-Sultan"));
        phoneBook.add(new Person("Vadim", "Petrov", "228", "Moscow"));
        var people = phoneBook.find("dim");
        Assert.assertThat(people.size(), Is.is(2));
    }
}
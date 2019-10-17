package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> findPerson  = new ArrayList<>();
        for (var i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().contains(key)
              || persons.get(i).getSurname().contains(key)
              || persons.get(i).getAdress().contains(key)
              || persons.get(i).getPhone().contains(key)) {
                findPerson.add(persons.get(i));
            }
        }
        return findPerson;
    }
}

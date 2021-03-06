package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenClassA() {
        List<Student> students = Arrays.asList(new Student(34),
                new Student(55),
                new Student(98),
                new Student(65),
                new Student(23));
        List<Student> result = new School().collect(students, x -> x.getScore() >= 70);
        assertThat(result.toString(), Is.is(Arrays.asList(
                new Student(98)
        ).toString()));
    }

    @Test
    public void whenClassB() {
        List<Student> students = Arrays.asList(new Student(34),
                                               new Student(55),
                                               new Student(98),
                                               new Student(65),
                                               new Student(23));
        List<Student> result = new School().collect(students, x -> (x.getScore() < 70) && (x.getScore() >= 50));
        assertThat(result.toString(), Is.is(Arrays.asList(
                                               new Student(55),
                                               new Student(65)
        ).toString()));
    }

    @Test
    public void whenClassC() {
        List<Student> students = Arrays.asList(new Student(34),
                                               new Student(55),
                                               new Student(98),
                                               new Student(65),
                                               new Student(23));
        List<Student> result = new School().collect(students, x -> (x.getScore() < 50));
        assertThat(result.toString(), Is.is(Arrays.asList(
                                               new Student(34),
                                               new Student(23)
        ).toString()));
    }

    @Test
    public void whenListToMap() {
        List<Student> students = Arrays.asList(new Student(34, "Petr", "Ivanov"),
                                               new Student(55, "Ivan", "Petrov"));
        Map<String, Student> result = new School().collectToMap(students);
        assertThat(result.values().toString(), Is.is(Arrays.asList(
                                               new Student(55, "Ivan", "Petrov"),
                                               new Student(34, "Petr", "Ivanov")
        ).toString()));
    }

    @Test
    public void whenResultListSortedAndNotNull() {
        List<StudentNew> students = Arrays.asList(
                                               new StudentNew("Ivan", 58),
                                               null,
                                               null,
                                               new StudentNew("Nik", 90),
                                               new StudentNew("Igor", 23),
                                               null,
                                               new StudentNew("Anna", 87),
                                               new StudentNew("Inna", 73));
        List<StudentNew> result = new School().levelOf(students, 60);
        assertThat(result.toString(), Is.is(Arrays.asList(
                                               new StudentNew("Nik", 90),
                                               new StudentNew("Anna", 87),
                                               new StudentNew("Inna", 73)
        ).toString()));
    }
}
package ru.job4j.sort;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ru.job4j.sort.Departments.convert;

public class DepartmetsTest {

    @Test
    public void whenAddDepartments() {
        List<Departments.Org> dep = Arrays.asList(
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K1\\SK1\\SSK1"),
                new Departments.Org("K1\\SK1\\SSK2"),
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K2\\SK1\\SSK2"));
        List<Departments.Org> convert = convert(dep);
        assertThat(convert, Is.is(Arrays.asList(
                new Departments.Org("K2\\SK1\\SSK2"),
                new Departments.Org("K2\\SK1"),
                new Departments.Org("K1"),
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK1\\SSK1"),
                new Departments.Org("K1\\SK1\\SSK2"))));
    }

    @Test
    public void whenNaturalSort() {
        List<Departments.Org> dep = Arrays.asList(
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K1\\SK1\\SSK1"),
                new Departments.Org("K1\\SK1\\SSK2"),
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K2\\SK1\\SSK2"));
        List<Departments.Org> convert = convert(dep);
        new Departments().sort(convert);
        assertThat(convert, Is.is(Arrays.asList(
                new Departments.Org("K1"),
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK1\\SSK1"),
                new Departments.Org("K1\\SK1\\SSK2"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K2\\SK1\\SSK2"))));
    }

    @Test
    public void whenSortDescend() {
        List<Departments.Org> dep = Arrays.asList(
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K1\\SK1\\SSK1"),
                new Departments.Org("K1\\SK1\\SSK2"),
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K2\\SK1\\SSK2"));
        List<Departments.Org> convert = convert(dep);
        new Departments().sortDesc(convert);
        assertThat(convert, Is.is(Arrays.asList(
                new Departments.Org("K2"),
                new Departments.Org("K2\\SK1"),
                new Departments.Org("K2\\SK1\\SSK2"),
                new Departments.Org("K2\\SK1\\SSK1"),
                new Departments.Org("K1"),
                new Departments.Org("K1\\SK2"),
                new Departments.Org("K1\\SK1"),
                new Departments.Org("K1\\SK1\\SSK2"),
                new Departments.Org("K1\\SK1\\SSK1")
                )));
    }

}
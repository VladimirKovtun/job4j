package ru.job4j;

import java.util.Objects;

public class StudentNew implements Comparable<StudentNew> {
    private String name;
    private int scope;

    public StudentNew() {
    }

    public StudentNew(String name, int score) {
        this.name = name;
        this.scope = score;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentNew that = (StudentNew) o;
        return scope == that.scope &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    @Override
    public String toString() {
        return "StudentNew{"
                + "name='" + name + '\''
                + ", scope=" + scope
                + '}';
    }

    @Override
    public int compareTo(StudentNew o) {
        return o.scope - this.scope;
    }
}

package ru.job4j;

import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private Set<String> eMail;

    public User() {}

    public User(String name, Set<String> eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public Set<String> geteMail() {
        return eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return name.equals(user.name)
                && eMail.equals(user.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eMail);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", eMail=" + eMail
                + '}';
    }
}

package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import static org.junit.Assert.*;

public class UserMailTest {

    @Test
    public void when() {
        List<User> userList = Arrays.asList(
                new User("user1", new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"))),
                new User("user2", new LinkedHashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net"))),
                new User("user3", new LinkedHashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com"))),
                new User("user4", new LinkedHashSet<>(Arrays.asList("ups@pisem.net", "aaa@bbb.ru"))),
                new User("user5", new LinkedHashSet<>(Arrays.asList("xyz@pisem.net"))));
        List<User> result = new UserMail().checkEmail(userList);
        assertThat(result.toString(), Is.is(Arrays.asList(
                new User("user1",
                        new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"))),
                new User("user3", new LinkedHashSet<>(Arrays.asList("xyz@pisem.net", "vasya@pupkin.com")))).toString()));
    }

    @Test
    public void when1() {
        List<User> userList = Arrays.asList(
                new User("user1", new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "lol@mail.ru"))),
                new User("user2", new LinkedHashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net"))),
                new User("user3", new LinkedHashSet<>(Arrays.asList("xyz@biz.net", "vasya@pupkin.com"))),
                new User("user4", new LinkedHashSet<>(Arrays.asList("lol@mail.ru", "aaa@bbb.ru"))),
                new User("user5", new LinkedHashSet<>(Arrays.asList("xyz@biz.net", "foo@gmail.com"))));
        List<User> result = new UserMail().checkEmail(userList);
        assertThat(result.toString(), Is.is(Arrays.asList(
                new User("user1",
                        new LinkedHashSet<>(Arrays.asList("xxx@ya.ru", "lol@mail.ru", "aaa@bbb.ru"))),
                new User("user2",
                        new LinkedHashSet<>(Arrays.asList("foo@gmail.com", "ups@pisem.net", "xyz@biz.net", "vasya@pupkin.com")))
        ).toString()));
    }

}

package ru.job4j.bank;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void whenTransfer() {
        Account accountFirst = new Account(123, "123");
        Account accountSecond = new Account(53, "1234");
        accountFirst.transfer(accountSecond, 24);
        assertThat(accountSecond.getValue(), Is.is(77d));
    }

    @Test
    public void whenTransferFalse() {
        Account accountFirst = new Account(123, "123");
        Account accountSecond = new Account(53, "1234");
        assertFalse(accountFirst.transfer(accountSecond, 249));
    }

}
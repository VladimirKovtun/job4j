package ru.job4j.bank;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        bank.addUser(new User("ivan", "asdf"));
        assertFalse(bank.isEmpty());
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Alex", "asdf");
        bank.addUser(user);
        bank.deleteUser(user);
        assertTrue(bank.isEmpty());
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user = new User("Alex", "asdf");
        bank.addUser(user);
        bank.addAccountToUser("asdf", new Account(323, "jkl"));
        Account rst = bank.getAcc("asdf", "jkl");
        assertThat(rst.getValue(), Is.is(323d));
    }

    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        User user = new User("Alex", "asdf");
        bank.addUser(user);
        Account newAcc3 = new Account(33, "jk");
        Account newAcc2 = new Account(3233, "kl");
        Account newAcc1 = new Account(3, "jk");
        bank.addAccountToUser("asdf", newAcc1);
        bank.addAccountToUser("asdf", newAcc2);
        bank.addAccountToUser("asdf", newAcc3);
        bank.deleteAccountFromUser("asdf", newAcc3);
        assertThat(bank.getUserAccounts("asdf").size(), Is.is(1));

    }

    @Test
    public void whenGet2UserAccountsRequisiteDuplicate() {
        Bank bank = new Bank();
        User user = new User("Alex", "asdf");
        bank.addUser(user);
        bank.addAccountToUser("asdf", new Account(33, "jk"));
        bank.addAccountToUser("asdf", new Account(3233, "kl"));
        bank.addAccountToUser("asdf", new Account(32, "jk"));
        List<Account> accList = bank.getUserAccounts("asdf");
        assertThat(accList.size(), Is.is(2));
    }

    @Test
    public void whenGet3UserAccounts() {
        Bank bank = new Bank();
        User user = new User("Alex", "asdf");
        bank.addUser(user);
        bank.addAccountToUser("asdf", new Account(33, "jk"));
        bank.addAccountToUser("asdf", new Account(3233, "kl"));
        bank.addAccountToUser("asdf", new Account(32, "jka"));
        List<Account> accList = bank.getUserAccounts("asdf");
        assertThat(accList.size(), Is.is(3));
    }

    @Test
    public void whenGetAcc() {
        Bank bank = new Bank();
        User userFirst = new User("Anton", "123asd");
        bank.addUser(userFirst);
        bank.addAccountToUser("123asd", new Account(122, "asd"));
        Account result = bank.getAcc("123asd", "asd");
        assertThat(result.getValue(), Is.is(122d));
    }

    @Test
    public void whenTransfer50MoneyExpect80() {
        Bank bank = new Bank();
        User userFirst = new User("Anton", "123asd");
        User userSecond = new User("Vadim", "321fds");
        bank.addUser(userFirst);
        bank.addAccountToUser("123asd", new Account(122, "asd"));
        bank.addUser(userSecond);
        bank.addAccountToUser("321fds", new Account(30, "dsa"));
        boolean result = bank.transferMoney("123asd", "asd", "321fds", "dsa", 50);
        assertThat(bank.getAcc("321fds", "dsa").getValue(), Is.is(80d));
    }

    @Test
    public void whenNotTransferMoneyWrongRequisiteThenFalse() {
        Bank bank = new Bank();
        User userFirst = new User("Anton", "123asd");
        User userSecond = new User("Vadim", "321fds");
        bank.addUser(userFirst);
        bank.addAccountToUser("123asd", new Account(122, "asd"));
        bank.addUser(userSecond);
        bank.addAccountToUser("321fds", new Account(30, "dsa"));
        boolean result = bank.transferMoney("123asd", "asd", "321fds", "ds", 50);
        assertFalse(result);
    }

    @Test
    public void whenTransferMoneyExpectBetwenOneUser() {
        Bank bank = new Bank();
        User userFirst = new User("Anton", "123asd");
        bank.addUser(userFirst);
        bank.addAccountToUser("123asd", new Account(122, "asd"));
        bank.addAccountToUser("123asd", new Account(30, "dsa"));
        boolean result = bank.transferMoney("123asd", "asd", "123asd", "dsa", 50);
        assertThat(bank.getAcc("123asd", "dsa").getValue(), Is.is(80d));
    }
}
package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> dataBase = new HashMap<>();

    public boolean isEmpty() {
        return dataBase.isEmpty();
    }

    public void addUser(User user) {
        if (user != null) {
            dataBase.putIfAbsent(user, new ArrayList<>());
        }
    }

    public void deleteUser(User user) {
        if (user != null && dataBase.containsKey(user)) {
            dataBase.remove(user);
        } else {
            System.out.println("User not deleted.");
        }
    }

    public void addAccountToUser(String passport, Account account) {
        dataBase.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport)
                        && account != null && !dataBase.get(key).contains(account))
                .findAny()
                .ifPresent(obj -> dataBase.get(obj).add(account));
        /*for (User next : dataBase.keySet()) {
            if (next.getPassport().equals(passport)) {
                if (account != null && !dataBase.get(next).contains(account)) {
                    dataBase.get(next).add(account);
                    break;
                }
            }
        }*/
    }

    public void deleteAccountFromUser(String passport, Account account) {
        dataBase.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport)
                        && dataBase.get(user).contains(account))
                .findFirst()
                .ifPresent(user -> dataBase.get(user).remove(account));
        /*for (User next : dataBase.keySet()) {
            if (next.getPassport().equals(passport)) {
                for (Account acc : dataBase.get(next)) {
                    if (acc.equals(account)) {
                        dataBase.get(next).remove(account);
                        break;
                    }
                }
            }
        }*/
    }

    public List<Account> getUserAccounts(String passport) {
        return dataBase.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getPassport().equals(passport))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

        /*List<Account> list = new ArrayList<>();
        for (User next : dataBase.keySet()) {
            if (next.getPassport().equals(passport)) {
                list = dataBase.get(next);
                break;
            }
        }
        return list;*/
    }

    public Account getAcc(String passport, String requisite) {
        return getUserAccounts(passport).stream()
                .filter(account -> account.getRequisites().equals(requisite))
                .findFirst()
                .orElse(null);
        /*Account account = null;
        List<Account> userAccounts = getUserAccounts(passport);
        for (Account acc : userAccounts) {
            if (acc.getRequisites().equals(requisite)) {
                int i = userAccounts.indexOf(acc);
                account = userAccounts.get(i);
                break;
            }
        }
        return account;*/
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String desPassport, String desRequisite, double amount) {
        Account srcAccount = getAcc(srcPassport, srcRequisite);
        Account desAccount = getAcc(desPassport, desRequisite);
        return srcAccount != null
                && desAccount != null
                && srcAccount.transfer(desAccount, amount);
    }
}

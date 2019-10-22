package ru.job4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserMail {

    public List<User> checkEmail(List<User> users) {
        List<User> userCopy = new ArrayList<>(users);
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (userCopy.contains(user)) {
                userCopy.remove(user);
                for (int i = 0; i < userCopy.size(); i++) {
                    if (!Collections.disjoint(user.geteMail(), userCopy.get(i).geteMail())) {
                        user.geteMail().addAll(userCopy.get(i).geteMail());
                        userCopy.remove(i--);
                    }
                }
                result.add(user);
            }
        }
        return result;
    }
}

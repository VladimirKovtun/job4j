package ru.job4j.list;

import java.util.HashMap;
import java.util.List;


public class UserConvert {

    public HashMap<Integer, User> process(List<User> userList) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User user : userList) {
            map.put(user.getId(), user);
        }
        return map;
    }
}

package com.webkeyz.batchtwotraining.model;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public static List<User> CreateUsers() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("user" + i, "0" + i);
            userList.add(user);
        }
        return userList;
    }
}
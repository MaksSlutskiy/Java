package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    public static final int USER_COUNT = 1000;
    private List<User> users;

    public UserStorage() {
        users = new ArrayList<>(USER_COUNT);

        for (int i = 0; i < USER_COUNT; i++) {
            users.add(new User(i, i * 1000, "User" + i));
        }
    }

    public List<User> getData(int startPosition, int size) {
        return users.subList(startPosition, startPosition + size);
    }
}

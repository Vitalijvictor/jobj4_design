package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        Calendar date = Calendar.getInstance();
        User user1 = new User("John", 2, date);
        User user2 = new User("John", 2, date);
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}

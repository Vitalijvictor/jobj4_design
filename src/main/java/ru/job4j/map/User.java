package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * В классе User не переопределять методы equals() и hasCode();
 * Создать два объекта User, которые имеют одинаковые поля.
 *
 * Создать карту Map<User, Object>
 *
 * Добавить две пары.
 * В качестве ключей использовать объекты User из пункта 2 а в качестве значения new Object() .
 * Вывести карту на печать. Описать полученный результат словами.
 *
 * Ответить на вопросы:
 *         5.1. Объекты попали в один бакет или в разные?
 *
 *         5.2. Вызывался ли в этом случае equals() у объектов User или нет? Объяснить почему
 *         Объясните полученный результат почему так получилось.
 */
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

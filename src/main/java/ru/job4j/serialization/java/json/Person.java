package ru.job4j.serialization.java.json;

import java.util.Arrays;

/**
 * JSON (JavaScript Object Notation)
 */
public class Person {
    private final boolean sex;
    private final int age;
    private final Contacts contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contacts contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
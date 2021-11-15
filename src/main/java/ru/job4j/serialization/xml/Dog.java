package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Dog {

    private final String sex;
    private final boolean evil;
    private final int age;
    private final Temper temper;
    private final String[] pets;

    public Dog(String sex, boolean evil, int age, Temper temper, String[] pets) {
        this.sex = sex;
        this.evil = evil;
        this.age = age;
        this.temper = temper;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Dog{" + "sex='" + sex + '\'' + ", evil=" + evil + ", age="
                + age + ", temper=" + temper + ", pets=" + Arrays.toString(pets) + '}';
    }

    public static void main(String[] args) {
        final Dog dog = new Dog("Male dog", true, 2, new Temper("very bad"),
                new String[] {"Rex", "Andoo", "Jello"});
        System.out.println(dog);
    }
}
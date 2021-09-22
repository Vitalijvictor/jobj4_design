package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 */
public class Lowerboundedwildcard {
    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args) {
        List<? super Integer> list = new ArrayList<>();
        new Lowerboundedwildcard().addAll(list);

        GenericsClass<String, String> gen = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + gen);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
    }
}

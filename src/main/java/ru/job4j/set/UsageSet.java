package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Fix comment errors
 */
public class UsageSet {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("two");
        strings.add("three");
        strings.addAll(List.of("one", "four", "five"));
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }
        System.out.println(System.lineSeparator());
        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
            System.out.println("Текущий элемент: " + it.next());
        }

        System.out.println(System.lineSeparator());
        strings.remove("two");
        System.out.println("Вывод в консоль после удаления two ");
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }

        System.out.println(System.lineSeparator());
        strings.removeAll(List.of("two", "three"));
        System.out.println("Вывод в консоль после удаления two, three ");
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }

        System.out.println(System.lineSeparator());
        strings.retainAll(List.of("one"));
        System.out.println("Вывод в консоль после удаления всех кроме one");
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }

        System.out.println(System.lineSeparator());
        strings.removeIf(s -> s.startsWith("t"));
        System.out.println("Удаление всех элементов которые начинаются на t");
        for (String s : strings) {
            System.out.println("Текущий элемент: " + s);
        }

        System.out.println(System.lineSeparator());
        boolean b = strings.contains("two");
        System.out.println("Множество содержит элемент: " + b);

        System.out.println(System.lineSeparator());
        int size = strings.size();
        System.out.println("Наше множество содержит: " + size + " элемент.");

        System.out.println(System.lineSeparator());
        strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(st -> System.out.println("Текущий элемент: " + st));
    }
}
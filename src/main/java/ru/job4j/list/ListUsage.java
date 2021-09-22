package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        /**
         * Очень важно понимать, что метод возвращает неизменяемый список,
         * т.е. вызвать метод add(), remove() и т.п.
         * на такой коллекции не получится,
         * будет сгенерировано исключение UnsupportedOperationException.
         */
        //List<String> rsl = List.of("one", "two", "three");
        /**
         * Такой метод можно изменять
         */
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        //rsl.add(1, "four");

//        List<String> list = new ArrayList<>();
//        list.add("four");
//        list.add("five");

        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");

        rsl.addAll(2, list);

//        rsl.addAll(list);
        Iterator<String> iterator = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }
        /**
         * Чтение элементов из списка:
         * 2.1. Использование метода get():
         *
         */
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент: " + rsl.get(i));
        }

        /**
         * 2.2. использовать итератор для доступа к элементам.
         * Iterator<String> iterator = rsl.iterator();
         * while (iterator.hasNext()) {
         *     System.out.println("Текущий элемент: " + iterator.next());
         * }
         */
        Iterator<String> iterator1 = rsl.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator1.next());
        }

        /**
         * 3. Изменение элементов в списке
         */
        rsl.set(1, "two and second");
    }
}
package ru.job4j.generics;

import java.util.*;

/**
 * 1. WildCard.
 * <?> В этом случае ограничений в использовании не будет (т.е. он имеет соответствие с любым типом).
 *
 * 2. Bounded Wildcard
 *  <? extends Person> "Ограничение сверху". Programmer extends Person.
 *  Вместо программер может быть любой класс который поторый наследуется от
 *  Person
 *
 *  3. Lower bounded Wildcard
 *  <? super A>
 *  Ограниченный снизу wildcard выражается с помощью wildcard символа ("?"),
 *  за которым следует ключевое слово super после которого указывается нижняя
 *  граница.
 *
 */
public class GenericUsage {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        for (int i = 0; i < list.size(); i++) {
            String s = (String) list.get(i); //  down casting
            System.out.println("Текущий элемент: " + s);
        }

        /**
         * способ до дженериков
         */
        List list1 = new ArrayList();
        list1.add("first");
        list1.add("second");
        list1.add("third");
        list1.add(new Person("name", 21, new Date(913716000000L)));
        System.out.println("Количество элементов в списке: " + list1.size());

        System.out.println(System.lineSeparator());
        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new GenericUsage().printInfo(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new GenericUsage().printInfo(pro);  //эта модель работает потому что
        // Programmer extends Person   <? extends Person>

        System.out.println(System.lineSeparator());
        List<? super Integer> list2 = new ArrayList<>();
        new GenericUsage().addAll(list2);

        System.out.println(System.lineSeparator());
        GenericsClass<String, String> gen = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + gen);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);

    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }
}
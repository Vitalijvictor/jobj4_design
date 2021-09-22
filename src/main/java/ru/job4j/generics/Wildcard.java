package ru.job4j.generics;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Wildcard {
    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3, 4, 5);
        new Wildcard().printRsl(l);

        List<Person> per = List.of(new Person("name", 21, new Date(913716000000L)));
        new Wildcard().printInfo(per);

        List<Programmer> pro = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new Wildcard().printInfo(pro);
    }
}
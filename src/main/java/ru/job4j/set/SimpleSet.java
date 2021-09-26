package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

/**
 * Для сравнения объектов использовать метод:
 *
 * https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Objects.html#equals(java.lang.Object,java.lang.Object)
 * @param <T>
 */
public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        if (value != value) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T el : set) {
            if (el.equals(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

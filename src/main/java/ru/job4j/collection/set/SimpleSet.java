package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;
import java.util.Set;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        return false;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
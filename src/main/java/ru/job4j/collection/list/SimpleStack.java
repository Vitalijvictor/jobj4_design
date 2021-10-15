package ru.job4j.collection.list;

import java.util.Iterator;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        Iterator<T> iter = linked.iterator();
        if (!iter.hasNext()) {
            return null;
        }
        T value = iter.next();
        linked.deleteFirst();
        return value;
    }
    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return !linked.iterator().hasNext();
    }
}
package ru.job4j.list;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
        modCount = 0;
        size = 0;
    }

    @Override
    public void add(T value) {
        if (container.length <= size) {
            container = Arrays.copyOf(container, container.length * 2); //1.5
            // + 1
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        for (T i : container) {
            index = (int) i;
            Array.set(container, index, newValue);
            modCount++;
        }
        return (T) container;
    }

    @Override
    public T remove(int index) {
        System.arraycopy(container,
                index + 1,
                container,
                index,
                container.length - index - 1);
        container[container.length - 1] = null;
        return (T) container;
    }

    @Override
    public T get(int index) {
        index = Arrays.asList(container).indexOf(index);
        return (T) container;
    }

    @Override
    public int size() {
        for (int i = size; i < container.length; i++) {
            if (size == 0) {
                return 0;
            }
        }
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (container.length >= size) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return null;
            }

        };
    }
}

package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    public int getSize() {
        return size;
    }

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
        Objects.checkIndex(index, container.length);
        T previous = container[index];
        container[index] = newValue;
        return previous;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length);
        T previous = container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[--size] = null;
        modCount++;
        return previous;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != size;
            }

            @Override
            public T next() {
                if (cursor >= size) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[cursor++];
            }

        };
    }
}

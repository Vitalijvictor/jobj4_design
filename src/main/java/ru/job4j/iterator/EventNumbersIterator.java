package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EventNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return data[index++];
        }
    }

}
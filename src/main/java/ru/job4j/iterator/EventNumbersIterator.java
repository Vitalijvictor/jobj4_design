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
        int value = 0;
     for (index = 0; index < data.length; index++) {
         if (data[index] % 2 == 0) {
             value = index;
            } else {
             return false;
         }
        }
     return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            this.hasNext();
        }
        return data[index++];
    }

}
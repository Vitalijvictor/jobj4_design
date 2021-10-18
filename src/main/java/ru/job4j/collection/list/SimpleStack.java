package ru.job4j.collection.list;

import java.util.Iterator;

/**
 * Stack - примитивная структура данных.
 * Работу этой структуры можно представить в виде тарелок поставленных друг на друга.
 * Новая тарелка всегда оказывается верхней.
 * Если нам нужно достать тарелку из середины стопки, то нужно снять верхние тарелки.
 *
 *
 * Stack лучше всего реализовать на базе связанного списка. Почему связанный список лучше всего подходит для этого?
 * Связанный список умеет быстро вставлять данные и удалять с начала или конца.
 * Это поведение как раз и нужно при реализации стэка.
 * @param <T>
 */
public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        Iterator<T> iter = linked.iterator();
        if (!iter.hasNext()) {
            return null;
        } else {
            linked.deleteFirst();
        }
        return iter.next();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return !linked.iterator().hasNext();
    }
}
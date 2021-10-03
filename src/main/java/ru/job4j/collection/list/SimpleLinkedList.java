package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public SimpleLinkedList() {
    }

    @Override
    public void add(E value) {
        if (last != null) {
            Node<E> tmp = new Node<>(value, null, last);
            last.next = tmp;
            last = tmp;
        } else {
            first = new Node<>(value, null, null);
            last = first;
        }
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, modCount);
        if (index == 0) {
            return first.item;
        }
        int temp = 0;
        Node<E> node = first;
        while (temp != index) {
            temp++;
            node = node.next;
        }
        return node.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int cursor = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }

            @Override
            public E next() {
                if (cursor >= modCount) {
                    throw  new ConcurrentModificationException();
                }
                return iterator().next();
            }
        };
    }
}

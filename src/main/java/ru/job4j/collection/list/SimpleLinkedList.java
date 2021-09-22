/*
package ru.job4j.collection.list;

import ru.job4j.generics.Node;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    transient Node<E> first;
    transient Node<E> last;
    transient Node<E> node;
    transient int size = 0;
    private int modCount = 0;

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, last, first);
        final Node<E> f = first;
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.next = newNode;
            size++;
            modCount++;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) node[index];
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }
        return (Iterator<E>) node[size++];
    }
}
*/
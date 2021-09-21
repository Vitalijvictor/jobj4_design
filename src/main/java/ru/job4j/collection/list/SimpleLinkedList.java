package ru.job4j.collection.list;

import ru.job4j.generics.Node;
import ru.job4j.tree.Tree;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    transient int size = 0;
//    transient Node<E> first;
//    transient Node<E> last;
    transient Node[] node;
    private int modCount;
    private int cursor;

    public SimpleLinkedList(int size, Node<E> first, Node<E> last, Node[] node, int modCount) {
        this.size = size;
//        this.first = first;
//        this.last = last;
        this.node = node;
        this.modCount = modCount;
        this.cursor = 0;
    }

    @Override
    public void add(E value) {
        if (node.length <= size) {
            node = Arrays.copyOf(node, node.length * 2);
        }
        node[size++] = (Node) value;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, node.length);
        return (E) node[index];
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }
        return (Iterator<E>) node[cursor++];
    }
}

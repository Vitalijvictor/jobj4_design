package ru.job4j.collection.list;

class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    public Node(E item, Node<E> next, Node<E> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    public static void main(String[] args) {
        Node<String> list = new Node("OK", null, null);
        list.next = new Node("WTF", null, list);



    }
}

package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (key == null || value == null) {
            return false;
        } else {
            if (count >= capacity) {
                return false;
            }
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null && key == table[i].key) {
                    table[i].value = value;
                    modCount++;
                    return true;
                }
            }

            table[count++] = new MapEntry<>(key, value);
            modCount++;
            return true;
        }
    }

    private int hash(int index) {
        return table[index].hashCode();
    }

    private int indexFor(int hash) {
        for (int i = 0; i < table.length; i++) {
            if (table[i].hashCode() == hash) {
                return i;
            }
        }
        return -1;
    }

    private void expand() {
        capacity = (int) (capacity * 1.5);
        table = Arrays.copyOf(table, capacity);
    }

    @Override
    public V get(K key) {
        for (MapEntry<K, V> t : table) {
            if (t != null && t.key.equals(key)) {
                return t.value;
            }
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        MapEntry<K, V>[] tmp = new MapEntry[table.length - 1];
        int j = 0;
        boolean hasFound = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                break;
            }

            if (!table[i].key.equals(key)) {
                tmp[j++] = table[i];
            } else {
                hasFound = true;
            }
        }
        if (!hasFound) {
            return false;
        }

        table = tmp;
        modCount++;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int initialModCount = modCount;
            int current = 0;

            @Override
            public boolean hasNext() {
                return (table[current] != null);
            }

            @Override
            public K next() {
                if (modCount != initialModCount) {
                    throw new ConcurrentModificationException();
                }

                return hasNext() ? table[current++].key : null;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
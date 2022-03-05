package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private  int count = 0;

    private  int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean rsl = false;
        if (count == capacity * LOAD_FACTOR) {
            expand();
        }
        int i = indexFor(hash(key.hashCode()));
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return (hashCode == 0) ? 0 : (hashCode ^ (hashCode >>> 16));
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        var newSize = new MapEntry[capacity];
        for (MapEntry<K, V> key : table) {
            if (key != null) {
                newSize[indexFor(key.key.hashCode())] = key;
            }
        }
        table = newSize;
    }

    @Override
    public V get(K key) {
        int i = indexFor(hash(key.hashCode()));
        V rsl = null;
        if (table[i] != null) {
           rsl = table[i].key.equals(key) ? table[i].value : null;
        }
        return rsl;
    }

    @Override
    public Boolean remove(K key) {
        int i = indexFor(hash(key.hashCode()));
        boolean rsl = false;
        if (table[i] != null) {
            rsl = table[i].key.equals(key);
            if (rsl) {
                table[i] = null;
                count--;
                modCount++;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int i = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (i < table.length && table[i] == null) {
                    i++;
                }
                return i < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[i++].key;
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

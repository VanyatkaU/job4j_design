package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public SimpleArrayList() {
    }

    private void grow() {
        if (container.length == 0) {
            container = Arrays.copyOf(container, 1);
        }
        container = Arrays.copyOf(container, container.length * 2);
        modCount++;
    }

    @Override
    public boolean add(T value) {
        if (size == container.length) {
            grow();
        }
            container[size++] = value;
            modCount++;
        return false;
    }

    @Override
    public T set(int index, T newValue) {
        T prevValue = get(index);
        container[index] = newValue;
        return prevValue;
    }

    @Override
    public T remove(int index) {
        T nextIndex = get(index);
        System.arraycopy(container,
                index + 1,
                container,
                index,
                size - index - 1);
        container[--size] = null;
        modCount++;
        Objects.checkIndex(index, size);
        return nextIndex;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            final int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}
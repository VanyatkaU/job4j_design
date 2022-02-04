package ru.job4j.list1;

public interface List<E> extends Iterable<E> {
    void add(E value);
    E get(int index);
}
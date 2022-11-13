package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP (Dependency Inversion Principle) - принципа инверсии зависимостей.
 * Т.к. поле для хранения - мапа, не абстракция, то мы зависим от реализации.
 */

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    protected final Map<Integer, SoftReference<String>> cache = new HashMap<>();

    public void put(int key, String value) {
        cache.put(key, new SoftReference<>(value));
    }

    public String get(int key) {
        String value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            value = load(key);
            put(key, value);
        }
        return value;
    }

    private String load(int key) {
        return null;
    }
}

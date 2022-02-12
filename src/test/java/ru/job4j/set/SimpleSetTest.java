package ru.job4j.set;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void checkNoDuplicates() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertFalse(set.add(null));
        assertTrue(set.contains(null));
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoSuchElement() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        var t = set.iterator();
        t.next();
        t.next();
        t.next();
    }

    @Test
    public void whenNoHasNext() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        var t = set.iterator();
        t.next();
        t.next();
        assertFalse(t.hasNext());
    }
}

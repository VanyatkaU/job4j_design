package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleMapTest {
    @Test
    public void whenPut() {
        Map<String, Integer> map = new SimpleMap<>();
        assertTrue(map.put("Test", 1));
    }

    @Test
    public void whenPutFalse() {
        Map<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Тест", 0);
        assertFalse(map.put("Test", 0));
    }

    @Test
    public void whenGet() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Тест", 2);
        assertEquals(Integer.valueOf(1), map.get("Test"));
    }

    @Test
    public void whenGetNotExist() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Тест", 2);
        assertEquals(null, map.get("Тест1"));
    }

    @Test
    public void whenRemove() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Тест", 2);
        assertTrue(map.remove("Test"));
    }

    @Test
    public void whenRemoveNotExist() {
        SimpleMap<String, Integer> map = new SimpleMap<>();
        map.put("Test", 1);
        map.put("Тест", 2);
        assertFalse(map.remove("Тест2"));
    }

    @Test
    public void whenAddAndGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("Test1", "1");
        map.put("Test2", "2");
        map.put("Test3", "3");
        assertThat(map.get("Test1"), is("1"));
        assertThat(map.get("Test2"), is("2"));
        assertThat(map.get("Test3"), is("3"));
    }

    @Test
    public void whenMapContainKey() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("Test", "1");
        map.put("Test", "2");
        assertThat(map.get("Test"), is("1"));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenNoSuchElementException() {
        Map<String, String> map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        iterator.next();
    }

    @Test
    public void whenIteratorHasNext() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("Test", "1");
        Iterator<String> iterator = map.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void whenIteratorNotHasNext() {
        SimpleMap<String, String> map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenIteratorNext() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("Test", "1");
        Iterator<String> iterator = map.iterator();
        assertThat(iterator.next(), is("Test"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorMod() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("Test", "1");
        Iterator<String> iterator = map.iterator();
        map.put("Test1", "2");
        iterator.next();
    }
}

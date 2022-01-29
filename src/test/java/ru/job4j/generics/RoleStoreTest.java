package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenUsernameIsIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Ivan"));
    }

    @Test
    public void whenAddAndFindThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Ivan"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindUsernameIsIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Ivan"));
        store.add(new Role("2", "July"));
        Role result = store.findById("2");
        assertThat(result.getRole(), is("Ivan"));
    }

    @Test
    public void whenReplaceThenUsernameIsJuly() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        store.replace("1", new Role("1", "July"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("July"));
    }

    @Test
    public void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        store.replace("10", new Role("10", "July"));
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Ivan"));
    }

    @Test
    public void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteUserThenUsernameIsIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRole(), is("Ivan"));
    }
}

package ru.job4j.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar data = new GregorianCalendar(2013, 12, 13);
        User daughter = new User("Vasilina", 1, data);
        User son = new User("Stepan", 2, data);
        Map<User, Object> map = new HashMap<>();
        map.put(daughter, new Object());
        map.put(son, new Object());
        System.out.println(map);
    }
}
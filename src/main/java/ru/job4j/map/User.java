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

    public static void main(String[] args) {
        Calendar dataV = new GregorianCalendar(2013, 12, 13);
        Calendar dataS = new GregorianCalendar(2020,  07,  07);
        User daughter = new User("Vasilina", 1, dataV);
        User son = new User("Stepan", 2, dataS);
        Map<User, Object> map = new HashMap<>();
        map.put(daughter, new Object());
        map.put(son, new Object());
        System.out.println(map);
    }
}

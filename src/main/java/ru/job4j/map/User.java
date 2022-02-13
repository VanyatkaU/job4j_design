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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            User user = (User) o;
            return children == user.children
                    && Objects.equals(name, user.name)
                    && Objects.equals(birthday, user.birthday);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar dataV = new GregorianCalendar(2013, 12, 13);
        User daughter = new User("Vasilina", 1, dataV);
        User daughter1 = new User("Vasilina", 1, dataV);
        Map<User, Object> map = new HashMap<>();
        map.put(daughter, new Object());
        map.put(daughter1, new Object());
        System.out.println(map);
    }
}


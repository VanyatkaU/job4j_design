package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("c:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.length()));
        System.out.println(String.format("file name : %s", file.getName()));
    }
}

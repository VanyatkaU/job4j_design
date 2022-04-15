package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        int[][] result = new int[10][10];
        try (FileOutputStream out = new FileOutputStream("multiple.txt")) {
            for (int row = 0; row < result.length; row++) {
                for (int cell = 0; cell < result.length; cell++) {
                out.write(String.valueOf((row + 1) * (cell + 1)).getBytes());
                out.write(" ".getBytes());
            }
            out.write(System.lineSeparator().getBytes());
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

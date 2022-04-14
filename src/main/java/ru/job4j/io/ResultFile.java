package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        int[][] result = new int[10][10];
        for (int row = 0; row < 10; row++) {
            for (int cell = 0; cell < 10; cell++) {
                result[row][cell] = (row + 1) * (cell + 1);
            }
        }
        String rsl = Arrays.deepToString(result);
        try (FileOutputStream out = new FileOutputStream("multiply.txt")) {
            out.write(rsl.getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

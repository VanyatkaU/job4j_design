package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("src/main/java/ru/job4j/io/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String i : lines) {
                boolean rsl = Integer.parseInt(i) % 2 == 0;
                System.out.println(i + " " + rsl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

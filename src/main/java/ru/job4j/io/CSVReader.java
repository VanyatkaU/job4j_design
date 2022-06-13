package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        List<Integer> columns = new ArrayList<>();
        StringJoiner result = new StringJoiner(argsName.get("delimiter"));
        try (BufferedReader br = new BufferedReader(new FileReader(
                argsName.get("path")))) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(
                    argsName.get("out"), StandardCharsets.UTF_8, true))) {
                var scanner = new Scanner(br)
                        .useDelimiter(argsName.get("delimiter"));
                var line = scanner.nextLine().split(argsName.get("delimiter"));
                var filterLines = argsName.get("filter").split(",");
                for (int i = 0; i < line.length; i++) {
                    for (String s : filterLines) {
                        if (line[i].equals(s)) {
                            columns.add(i);
                            result.add(line[i]);
                        }
                    }
                }
                if (argsName.get("out").contains("stdout")) {
                    System.out.println(result);
                } else {
                    pw.println(result);
                }
                result = new StringJoiner(argsName.get("delimiter"));
                while (scanner.hasNext()) {
                    line = scanner.nextLine().split(argsName.get("delimiter"));
                    for (Integer number : columns) {
                        result.add(line[number]);
                    }
                    if (argsName.get("out").contains("stdout")) {
                        System.out.println(result);
                    } else {
                        pw.println(result);
                    }
                    result = new StringJoiner(argsName.get("delimiter"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(String[] args) {
        ArgsName arg = ArgsName.of(args);
        if (!arg.get("path").endsWith(".csv") || arg.get("path").isEmpty()) {
            throw new IllegalArgumentException("Invalid argument. Specify - .csv");
        }
        if (new File("path").isDirectory()) {
            throw new IllegalArgumentException("The path is a directory. Specify the path to the file");
        }
        return true;
    }

    public static void main(String[] args) {
        if (isValid(args)) {
            if (args.length != 4) {
                throw new IllegalArgumentException("The root folder is empty or there are not enough options. "
                                                   + "-path=file.csv -delimiter=\";\"  -out=stdout -filter=name,age");
            }
            var argsName = ArgsName.of(args);
            CSVReader.handle(argsName);
        }
    }
}
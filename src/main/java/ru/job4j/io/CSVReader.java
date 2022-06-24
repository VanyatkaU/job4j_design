package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        try (BufferedReader br = new BufferedReader(new FileReader(
                argsName.get("path")))) {
            var scanner = new Scanner(br)
                    .useDelimiter(argsName.get("delimiter"));
            List<Integer> columns = new ArrayList<>();
            StringJoiner result = new StringJoiner(argsName.get("delimiter"));
            var line = scanner.nextLine().split(argsName.get("delimiter"));
            var filterLines = argsName.get("filter").split(",");
            for (int i = 0; i < line.length; i++) {
                for (String s : filterLines) {
                    if (s.equals(line[i])) {
                        columns.add(i);
                        result.add(line[i]);
                    }
                }
            }
            if ("stdout".equals(argsName.get("out"))) {
                System.out.println(result);
            } else {
                try (PrintWriter pw = new PrintWriter(new FileWriter(
                        argsName.get("out"), StandardCharsets.UTF_8, true))) {
                    pw.write(result + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            result = new StringJoiner(argsName.get("delimiter"));
            check(argsName, result, scanner, columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void check(ArgsName argsName, StringJoiner result,
                              Scanner scanner, List<Integer> columns) {
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(argsName.get("delimiter"));
            for (int i = 0; i < line.length; i++) {
                if (columns.contains(i)) {
                    result.add(line[i]);
                }
            }
            if ("stdout".equals(argsName.get("out"))) {
                System.out.println(result);
            } else {
                try (PrintWriter pw = new PrintWriter(new FileWriter(
                        argsName.get("out"), StandardCharsets.UTF_8, true))) {
                    pw.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            result = new StringJoiner(argsName.get("delimiter"));
        }
    }

    private static boolean isValid(String[] args) {
        ArgsName arg = ArgsName.of(args);
        if (!arg.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("Invalid argument. Specify - .csv.");
        }
        if (!new File(arg.get("path")).isFile()) {
            throw new IllegalArgumentException("The specified source file does not exist.");
        }
        if (args.length != 4) {
            throw new IllegalArgumentException("The root folder is empty or there are not enough options. "
                                               + "-path=file.csv -delimiter=\";\"  -out=stdout -filter=name,age");
        }
        return true;
    }

    public static void main(String[] args) {
        if (isValid(args)) {
            var argsName = ArgsName.of(args);
            CSVReader.handle(argsName);
        }
    }
}
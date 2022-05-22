package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("The key is specified incorrectly");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] map = arg.split("=", 2);
            isValid(map);
            values.put(map[0].substring(1), map[1]);
        }
    }

    private static void isValid(String[] map) {
        if (!map[0].startsWith("-") || map[0].length() < 2) {
            throw new IllegalArgumentException("The key format does not match the template");
        }
        if (map.length != 2 || map[1].isEmpty()) {
            throw new IllegalArgumentException("The value or key are missing");
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("The args is empty");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}

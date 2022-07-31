package ru.job4j.examinputoutput;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Predicate;

public class FilesSearch {

    private static void findFiles(ArgsName argsName) {
        Predicate<Path> result = null;
        if ("name".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().equals(argsName.get("n"));
        } else if ("mask".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().equals(argsName.get("n"));
        } else if ("regex".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().equals(argsName.get("n"));
        }
        writeToFile(argsName, result);
    }

    private static void writeToFile(ArgsName argsName, Predicate<Path> result) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(argsName.get("o"), StandardCharsets.UTF_8))) {
            writer.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void isValid(String[] args, ArgsName argsName) {
        String help = """
                Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.?xt -t=mask -o=log.txt
                Ключи:
                -d - директория, в которой начинать поиск.
                -n - имя файла, маска, либо регулярное выражение.
                -t - тип поиска: mask искать по маске, name по полному совпадению имени, regex по регулярному выражению.
                -o - результат записать в файл .txt.""";
        if (args.length != 4) {
            throw new IllegalArgumentException("The root folder is empty or "
                                               + "it does not have the correct number of arguments. "
                                               + help);
        }
        if (!new File((argsName.get("d"))).isDirectory()) {
            throw new IllegalArgumentException("The root folder is not a directory. " + help);
        }
        if (!"name".equals(argsName.get("t"))
            && "mask".equals(argsName.get("t"))
            && "regex".equals(argsName.get("t"))) {
            throw new IllegalArgumentException("Does not match the search type. " + help);
        }
        if (!argsName.get("o").endsWith(".txt")) {
            throw new IllegalArgumentException("Incorrect file format for recording the result. " + help);
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        isValid(args, argsName);
        findFiles(argsName);
    }
}

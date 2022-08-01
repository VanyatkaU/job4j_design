package ru.job4j.examinputoutput;

import ru.job4j.io.ArgsName;
import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class FilesSearch {

    private static Predicate<Path> typeSelection(ArgsName argsName) {
        Predicate<Path> result = null;
        if ("name".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().equals(argsName.get("n"));
        } else if ("mask".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().matches(argsName.get("n")
                    .replace("*", ".*"));
        } else if ("regex".equals(argsName.get("t"))) {
            result = path -> path.toFile().getName().equals(argsName.get("n"));
        }
        return result;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void writeToFile(List<Path> files, String result) {
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(result, StandardCharsets.UTF_8))) {
            for (Path file : files) {
                writer.println(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void isValid(String[] args, ArgsName argsName) {
        String help = "Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.?xt -t=mask -o=log.txt"
                      + "Ключи:"
                      + "-d - директория, в которой начинать поиск."
                      + "-n - имя файла, маска, либо регулярное выражение."
                      + "-t - тип поиска: mask искать по маске, name по полному совпадению имени, regex по регулярному выражению."
                      + "-o - результат записать в файл .txt.";
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

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        isValid(args, argsName);
        Predicate<Path> result = typeSelection(argsName);
        List<Path> list = search(Path.of(argsName.get("d")), result);
        writeToFile(list, argsName.get("o"));
    }
}

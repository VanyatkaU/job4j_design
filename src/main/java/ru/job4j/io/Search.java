package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (isValid(args)) {
            Path start = Paths.get(args[0]);
            search(start, path -> path.toFile().getName()
                    .endsWith(args[1]))
                    .forEach(System.out::println);
        }
    }

    private static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static boolean isValid(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("The root folder is empty or there are not enough options. "
                                               + "Use template: root folder, .txt");
        }
        if (args.length > 2) {
            throw new IllegalArgumentException("More than two arguments. Specify the number of arguments - 2");
        }
        if (!new File(args[0]).isDirectory()) {
            throw new IllegalArgumentException("Not directory.");
        }
        return true;
    }
}

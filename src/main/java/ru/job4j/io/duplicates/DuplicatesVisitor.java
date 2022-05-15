package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> duplicate = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!duplicate.containsKey(fileProperty)) {
            duplicate.put(fileProperty, new ArrayList<>());
        }
        duplicate.get(fileProperty).add(file.toAbsolutePath());

        return super.visitFile(file, attrs);
    }

    public void result() {
        for (Map.Entry<FileProperty, List<Path>> entry : duplicate.entrySet()) {
            if (entry.getValue().size() > 1) {
                int i = 0;
                while (i < entry.getValue().size()) {
                    System.out.println("Duplicates: " + entry.getValue().get(i++));
                }
            }
        }
    }
}
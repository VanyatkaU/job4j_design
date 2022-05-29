package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path file : sources) {
                zip.putNextEntry(new ZipEntry(file.toAbsolutePath().toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void isValid(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("The root folder is empty or there are not enough options. "
                                               + "Use template: -d=c:\\project\\job4j\\ -e=.class -o=project.zip");
        }
        ArgsName argsName = ArgsName.of(args);
        if (!new File(argsName.get("d")).isDirectory()) {
            throw new IllegalArgumentException("Not directory.");
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("File extension, is not an argument. "
                                               + "Specify: -e=.class");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Archive name not specified");
        }
    }


    public static void main(String[] args) {
        isValid(args);
        ArgsName argsName = ArgsName.of(args);
        Path start = Path.of(argsName.get("d"));
        List<Path> files = null;
        try {
            files = Search.search(start, path -> !path.toFile().getName()
                    .endsWith("." + argsName.get("e")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        File toArshive = new File(argsName.get("o"));
        packFiles(files, toArshive);

        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}
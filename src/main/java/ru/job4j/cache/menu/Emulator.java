package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    public static final int ADD_FILE_CACHE = 1;
    public static final int GET_CONTENT_FILE = 2;

    public static final String ENTER = "Укажите путь к кэшируемой директории: ";
    public static final String FILE = "Введите имя файла: ";
    public static final String SELECT = "Выберите меню: ";
    public static final String GET = "Получить содержимое файла из кэш: ";
    public static final String EXIT = "Выход";

    public static final String MENU = """
                Введите 1 для загрузки файла в кэш.
                Введите 2 для получения содержимого файла из кэш.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        System.out.println(ENTER);
        Scanner scanner = new Scanner(System.in);
        DirFileCache cache = new DirFileCache(scanner.nextLine());
        System.out.println(SELECT);
        System.out.println(MENU);
        int userChoice = Integer.parseInt(scanner.nextLine());
        boolean run = true;
        while (run) {
            if (ADD_FILE_CACHE == userChoice) {
                System.out.println(FILE);
                System.out.println(cache.get(scanner.nextLine()));
                System.out.println(SELECT);
                System.out.println(MENU);
                userChoice = Integer.parseInt(scanner.nextLine());
            } else if (GET_CONTENT_FILE == userChoice) {
                System.out.println(GET);
                System.out.println(cache.get(scanner.nextLine()));
                System.out.println(SELECT);
                System.out.println(MENU);
                userChoice = Integer.parseInt(scanner.nextLine());
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
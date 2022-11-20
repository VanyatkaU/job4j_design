package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final int ADD_ITEM = 1;
    public static final int ADD_SUB_ITEM = 2;
    public static final int SHOW_ITEMS = 3;

    public static final String SELECT = "Выберите действие";
    public static final String ENTER_ITEM = "Введите пункт меню";
    public static final String ENTER_SUB_ITEM = "Введите подпункт меню";
    public static final String EXIT = "Конец работы";
    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static final String ACTION = """
            Введите 1, чтобы добавить пункт меню.
            Введите 2, чтобы добавить подпункт меню.
            Введите 3, чтобы показать все меню.
            Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        Scanner scanner = new Scanner(System.in);
        start(menu, scanner);
    }

    private static void start(Menu menu, Scanner scanner) {
        MenuPrinter printer = new MenuPrinter();
        boolean run = true;
        while (run) {
            System.out.println(ACTION);
            System.out.println(SELECT);
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println(choice);
            if (ADD_ITEM == choice) {
                System.out.println(ENTER_ITEM);
                String newItem = scanner.nextLine();
                menu.add(Menu.ROOT, newItem, STUB_ACTION);
            } else if (ADD_SUB_ITEM == choice) {
                System.out.println(ENTER_ITEM);
                String parent = scanner.nextLine();
                System.out.println(ENTER_SUB_ITEM);
                String child = scanner.nextLine();
                menu.add(parent, child, STUB_ACTION);
            } else if (SHOW_ITEMS == choice) {
                printer.print(menu);
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }
}
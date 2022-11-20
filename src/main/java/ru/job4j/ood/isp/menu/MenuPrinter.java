package ru.job4j.ood.isp.menu;

public class MenuPrinter implements MenuPrint {

    private static final String SEPARATOR = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo i : menu) {
            System.out.println(
                    numberIndex(i.getNumber()) + i.getName());
        }
    }

    private String numberIndex(String number) {
        int index = number.split("\\.").length - 1;
        return SEPARATOR.repeat(index) + number;
    }
}
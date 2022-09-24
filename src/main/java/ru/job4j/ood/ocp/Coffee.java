package ru.job4j.ood.ocp;

/**
 * Класс описывает кофейные напитки из разных сортов кофе.
 * Растет популярность чаепития и нам нужно добавить чай.
 * Необходимо будет изменить класс, добавить классы чая,
 * что нарушает принцип ОСР.
 * Просто расширить класс Coffee нельзя. Решение - создать
 * интерфейс Drinks и от него реализовывать напитки по классам.
 */

public class Coffee {

    private static class Arabic extends Coffee {
        public void espresso() {

        }

        public void americano() {

        }
    }

    private static class Robust extends Coffee {
        public void cappuccino() {

        }

        public void latte() {

        }
    }
}

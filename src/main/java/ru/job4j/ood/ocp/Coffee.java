package ru.job4j.ood.ocp;

import java.util.List;

/**
 * Класс описывает кофейные напитки из разных сортов кофе.
 * Поле coffees должно быть типом абстракции, но на данный момент
 * является списком типа Coffee.
 * Метод addForCooking() принимает параметр конкретного типа.
 * При добавлении для приготовления другого напитка, необходимо
 * будет вносить изменения в класс.
 */

public class Coffee implements Drinks {

    private List<Coffee> coffees;

    private class Arabic extends Coffee {

        public Coffee addForCooking(Coffee espresso) {
            coffees.add(espresso);
            return espresso;
        }
    }
}
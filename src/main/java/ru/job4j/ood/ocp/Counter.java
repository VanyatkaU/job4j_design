package ru.job4j.ood.ocp;

/**
 * Класс реализует определение суммы.
 * Если будет необходимо определять произведение
 * придется внести изменения в метод, что
 * нарушает принцип ОСР.
 * Решение вижу в создании интерфейсов, которые реализуют
 * свои вычисления.
 */

public class Counter {

    public static int sum(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

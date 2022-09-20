package ru.job4j.ood.srp;

/**
 * Класс синглтона, помимо непосредственных обязанностей,
 * занимается еще и контролированием количества своих экземпляров.
 */

public class SingletonSrp {

    private static SingletonSrp instance;

    private SingletonSrp() {
    }

    public static SingletonSrp getInstance() {
        if (instance == null) {
            synchronized (SingletonSrp.class) {
                if (instance == null) {
                    instance = new SingletonSrp();
                }
            }
        }
        return instance;
    }
}

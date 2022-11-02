package ru.job4j.ood.isp;

/**
 * Пример № 1.
 * Нарушение принципа ISP (Interface Segregation Principle),
 * т.к. содержит более трех методов.
 */

public interface Pupils {

    void playMusic();

    void song();

    void dance();

    void actor();

}

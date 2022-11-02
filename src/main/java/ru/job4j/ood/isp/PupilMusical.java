package ru.job4j.ood.isp;

/**
 * Пример № 2.
 * Нарушение принципа ISP (Interface Segregation Principle),
 * т.к. для исполнения мюзикла не нужна игра на инструменте.
 */

public class PupilMusical implements Pupils {

    @Override
    public void playMusic() {
        throw new IllegalArgumentException();
    }

    @Override
    public void song() {
        System.out.println("La-la-la");
    }

    @Override
    public void dance() {
        System.out.println("Performs pirouettes");
    }

    @Override
    public void actor() {
        System.out.println("Portrays emotions");
    }
}

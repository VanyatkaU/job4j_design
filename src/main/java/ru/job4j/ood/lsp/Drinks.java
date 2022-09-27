package ru.job4j.ood.lsp;

/**
 * Нарушения принципа LSP (Liskov Substitution Principle).
 * Класс Cappuccino усиливает условие метода mix()
 * родительского класса Drinks.
 * Класс FlatWhit ослабляет постусловие вспенивания класса Drinks.
 * Также класс FlatWhit не использует все условия базового класса Drinks.
 */

public class Drinks {

    private int milk;

    public Drinks(int milk) {
        this.milk = milk;
    }

    public void mix(int ml) {
        if (ml == 0) {
            throw new IllegalArgumentException("Укажите объем напитка!");
        }
        if (ml < 90) {
            throw new IllegalArgumentException("Не достаточно для смешивания!");
        }
        if (milk < ml / 3) {
            throw new IllegalArgumentException("Не достаточно для смешивания!");
        }
        if (milk > ml / 2) {
            throw new IllegalArgumentException("Не верная пропорция для вспенивания!"
                                                    + "Получится Latte");
        }
    }

    class Cappuccino extends Drinks {

        public Cappuccino(int milk) {
            super(milk);
        }

        public void mix(int ml) {
            if (ml == 0) {
                throw new IllegalArgumentException("Укажите объем напитка!");
            }
            if (ml < 100) { /** условие усилено */
                throw new IllegalArgumentException("Не достаточно для смешивания!");
            }
            if (milk < ml / 3) {
                throw new IllegalArgumentException("Не достаточно для смешивания!");
            }
            if (milk > ml / 2) {
                throw new IllegalArgumentException("Не верная пропорция для вспенивания!"
                                                   + "Получится Latte");
            }
        }
    }

    class FlatWhite extends Drinks {

        public FlatWhite(int milk) {
            super(milk);
        }

        public void mix(int ml) {
            if (ml == 0) {
                throw new IllegalArgumentException("Укажите объем напитка!");
            }
            if (ml < 90) {
                throw new IllegalArgumentException("Не достаточно для смешивания!");
            }
            if (milk < ml / 3) {
                throw new IllegalArgumentException("Не достаточно для смешивания!");
            }
            /** не используется условие пропорции для вспенивания */
        }
    }
}

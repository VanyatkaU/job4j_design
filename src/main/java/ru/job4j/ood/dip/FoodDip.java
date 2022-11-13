package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP (Dependency Inversion Principle) - принципа инверсии зависимостей.
 * Сохранение идет в память, следует FoodDip реализовать через абстракцию.
 */

import java.util.ArrayList;
import java.util.List;

public class FoodDip {

    private String name;

    public final List<String> foods = new ArrayList<>();

    public FoodDip() {
    }

    public boolean add(BreadDip bread) {
        if (foods.contains(bread.getName())) {
            return true;
        }
        return foods.add(bread.getName());
    }
}
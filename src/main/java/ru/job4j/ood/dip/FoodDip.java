package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP (Dependency Inversion Principle) - принципа инверсии зависимостей.
 * Сохранение идет в память, следует FoodDip реализовать через абстракцию, т.е.
 * создать интерфейс хранения продуктов, вывести реализацию добавления в другой класс,
 * а этот будет зависеть от класса реализации (или сам быть в виде абстракции - public abstract class FoodDip).
 */

import java.util.ArrayList;
import java.util.List;

public class FoodDip {

    private String name;

    public final List<String> foods = new ArrayList<>();

    public FoodDip(String name) {
    }

    public boolean add(BreadDip bread) {
        if (foods.contains(bread.getName())) {
            return true;
        }
        return foods.add(bread.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
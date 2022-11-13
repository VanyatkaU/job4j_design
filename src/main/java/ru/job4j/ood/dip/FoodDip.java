package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP (Dependency Inversion Principle) - принципа инверсии зависимостей.
 * Сохранение идет в память, следует FoodDip реализовать через абстракцию.
 */

import ru.job4j.ood.lsp.productStore.model.Bread;

import java.util.ArrayList;
import java.util.List;

public class FoodDip {

    private String name;

    public final List<String> foods = new ArrayList<>();

    public FoodDip() {
    }

    public boolean add(Bread bread) {
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

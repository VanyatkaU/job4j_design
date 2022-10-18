package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {

    private final List<Food> trash = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) >= Constants.LIMIT_100) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(trash);
    }
}
package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.AbstractStore.getPercentExpiry;
import static ru.job4j.ood.lsp.Constants.LIMIT_25;

public class Warehouse implements  Store {

    private final List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) < LIMIT_25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(warehouse);
    }
}

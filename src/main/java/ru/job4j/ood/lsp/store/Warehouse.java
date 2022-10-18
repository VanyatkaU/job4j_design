package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.store.Constants.LIMIT_25;

public class Warehouse extends AbstractStore {

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

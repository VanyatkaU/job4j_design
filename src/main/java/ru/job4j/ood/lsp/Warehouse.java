package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements  Store {

    private final double limit25 = 25D;
    private final List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) < limit25) {
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
package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    private final List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (isNotExpired(food)) {
            foods.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(foods);
    }

    protected abstract boolean isNotExpired(Food food);

}

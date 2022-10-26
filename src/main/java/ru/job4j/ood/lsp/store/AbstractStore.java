package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    public final ExpirationCalculator<LocalDateTime> expirationCalculator;

    private final List<Food> foods = new ArrayList<>();


    protected final List<Food> warehouse = new ArrayList<>();
    protected final List<Food> trash = new ArrayList<>();

    protected AbstractStore(ExpirationCalculator<LocalDateTime> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (isExpired(food)) {
            foods.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(foods);
    }

    protected abstract boolean isExpired(Food food);

}

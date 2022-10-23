package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.store.Constants.*;

public abstract class AbstractStore implements Store {

    private final ExpirationCalculator<LocalDateTime> expirationCalculator;

    protected final List<Food> shop = new ArrayList<>();
    protected final List<Food> warehouse = new ArrayList<>();
    protected final List<Food> trash = new ArrayList<>();

    protected AbstractStore(ExpirationCalculator<LocalDateTime> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= LIMIT_25
            && expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < LIMIT_100) {
            if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                    food.getExpiryDate()) >= LIMIT_75) {
                food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            }
            shop.add(food);
            rsl = true;
        }
        if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= LIMIT_100) {
            trash.add(food);
            rsl = true;
        }
        if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < LIMIT_25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> rsl = new ArrayList<>();
        if (rsl.equals(trash)) {
            rsl = List.copyOf(trash);
        }
        if (rsl.equals(warehouse)) {
            rsl = List.copyOf(warehouse);
        }
        if (rsl.equals(shop)) {
            rsl = List.copyOf(shop);
        }
        return rsl;
    }

    protected abstract List<Food> isExpired();

}

package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.store.Constants.*;

public class Shop extends AbstractStore {

    private final List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) >= LIMIT_25 && getPercentExpiry(food) < LIMIT_100) {
            if (getPercentExpiry(food) >= LIMIT_75) {
                food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            }
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(shop);
    }
}
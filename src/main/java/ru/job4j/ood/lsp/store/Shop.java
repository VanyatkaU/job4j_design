package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.store.Constants.*;

public class Shop extends AbstractStore {

    protected final List<Food> shop = new ArrayList<>();

    public Shop() {
        super(LocalDateTime::compareTo);
    }

    @Override
    protected boolean isExpired(Food food) {
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
        return rsl;
    }
}
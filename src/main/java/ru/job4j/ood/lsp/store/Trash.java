package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;

import static ru.job4j.ood.lsp.store.Constants.LIMIT_100;

public class Trash extends AbstractStore {

    public Trash() {
        super(LocalDateTime::compareTo);
    }

    @Override
    protected boolean isExpired(Food food) {
        boolean rsl = false;
        if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= LIMIT_100) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }
}
package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;

import java.time.LocalDateTime;

public class Trash extends AbstractStore {

    private final double LIMIT = 100D;

    private final ExpirationCalculator<LocalDateTime> expirationCalculator;

    public Trash(ExpirationCalculator<LocalDateTime> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
        return expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= LIMIT;
    }

}
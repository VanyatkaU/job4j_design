package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;

import java.time.LocalDateTime;

public class Warehouse extends AbstractStore {

    private static final double THRESHOLD_LOWER = 25D;

    private final ExpirationCalculator<LocalDateTime> expirationCalculator;

    public Warehouse(ExpirationCalculator<LocalDateTime> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
        return expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < THRESHOLD_LOWER;
    }
}
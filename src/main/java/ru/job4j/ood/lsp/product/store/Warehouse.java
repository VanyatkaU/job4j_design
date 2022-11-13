package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;
import ru.job4j.ood.lsp.product.util.ExpirationCalculator;

import java.time.LocalDateTime;

public class Warehouse extends AbstractStore {

    public static final double THRESHOLD_LOWER = 25D;

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
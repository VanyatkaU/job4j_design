package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;
import ru.job4j.ood.lsp.product.util.ExpirationCalculator;

import java.time.LocalDateTime;

import static ru.job4j.ood.lsp.product.store.Trash.LIMIT;
import static ru.job4j.ood.lsp.product.store.Warehouse.THRESHOLD_LOWER;

public class Shop extends AbstractStore {

    public static final double THRESHOLD_UPPER = 75D;

    private ExpirationCalculator<LocalDateTime> expirationCalculator;

    public Shop(ExpirationCalculator<LocalDateTime> expirationCalculator) {
        this.expirationCalculator = expirationCalculator;
    }

    @Override
    protected boolean isNotExpired(Food food) {
            if (expirationCalculator.calculateInPercent(food.getCreateDate(),
                    food.getExpiryDate()) >= THRESHOLD_UPPER) {
                food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            }
        return expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= THRESHOLD_LOWER && expirationCalculator.calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < LIMIT;
    }
}
package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class AbstractStore implements Store {

    static double getPercentExpiry(Food food) {
        double expiryOne = ChronoUnit.DAYS.between(food.getCreateDate(),
                food.getExpiryDate());
        double expiryTwo = ChronoUnit.DAYS.between(food.getCreateDate(),
                LocalDateTime.now());
        return expiryTwo / expiryOne * 100;
    }
}

package ru.job4j.ood.lsp.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExpirationCalculator implements ExpirationCalculator<LocalDateTime> {

    private static final int PERCENTAGE = 100;

    @Override
    public int calculateInPercent(LocalDateTime startDate, LocalDateTime endDate) {
        double expiryOne = ChronoUnit.DAYS.between(startDate, endDate);
        double expiryTwo = ChronoUnit.DAYS.between(startDate, LocalDateTime.now());
        return (int) (expiryTwo / expiryOne * PERCENTAGE);
    }
}
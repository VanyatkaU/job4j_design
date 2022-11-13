package ru.job4j.ood.lsp.product.util;

public interface ExpirationCalculator<T> {

    int calculateInPercent(T startDate, T endDate);

}

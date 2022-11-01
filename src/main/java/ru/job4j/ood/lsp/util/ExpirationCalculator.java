package ru.job4j.ood.lsp.util;

public interface ExpirationCalculator<T> {

    int calculateInPercent(T startDate, T endDate);

}

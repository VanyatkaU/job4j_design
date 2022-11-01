package ru.job4j.ood.lsp.model;

import java.time.LocalDateTime;

public class Bread extends Food {
    public Bread(String name, LocalDateTime expiryDate,
                 LocalDateTime createDate, double price,
                 double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

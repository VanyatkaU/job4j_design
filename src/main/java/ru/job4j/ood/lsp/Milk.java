package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Milk extends Food {

    public Milk(String name, LocalDateTime expiryDate,
                LocalDateTime createDate, double price,
                double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

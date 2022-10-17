package ru.job4j.ood.lsp;

import java.time.LocalDateTime;

public class Butter extends Food {
    public Butter(String name, LocalDateTime expiryDate,
                  LocalDateTime createDate, double price,
                  double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
package ru.job4j.ood.dip;

import ru.job4j.ood.lsp.productStore.model.Food;

import java.time.LocalDateTime;

public class BreadDip extends Food {
    public BreadDip(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}

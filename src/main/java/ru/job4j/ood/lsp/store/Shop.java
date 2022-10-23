package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.List;

public class Shop extends AbstractStore {

    public Shop() {
        super(LocalDateTime::compareTo);
    }

    @Override
    protected List<Food> isExpired() {
        return shop;
    }
}
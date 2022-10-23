package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.List;

public class Trash extends AbstractStore {

    public Trash() {
        super(LocalDateTime::compareTo);
    }

    @Override
    protected List<Food> isExpired() {
        return List.copyOf(trash);
    }
}
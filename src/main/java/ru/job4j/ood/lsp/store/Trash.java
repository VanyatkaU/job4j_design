package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore {

    private final double mAX = 100D;

    protected final List<Food> trash = new ArrayList<>();

    @Override
    protected boolean isNotExpired(Food food) {
        boolean rsl = false;
        if (calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= mAX) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    private double calculateInPercent(LocalDateTime createDate, LocalDateTime expiryDate) {
        return 0;
    }
}
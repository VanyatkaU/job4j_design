package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends AbstractStore {

    private final double LIMIT_25 = 25D;

    protected final List<Food> warehouse = new ArrayList<>();

    @Override
    protected boolean isNotExpired(Food food) {
        boolean rsl = false;
        if (calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < LIMIT_25) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    private double calculateInPercent(LocalDateTime createDate, LocalDateTime expiryDate) {
        return 0;
    }
}

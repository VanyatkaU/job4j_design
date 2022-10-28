package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Shop extends AbstractStore {

    private final double Limit_100 = 100D;
    private final double Limit_75 = 75D;
    private final double Limit_25 = 25D;

    protected final List<Food> shop = new ArrayList<>();

    @Override
    protected boolean isNotExpired(Food food) {
        boolean rsl = false;
        if (calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) >= Limit_25
            && calculateInPercent(food.getCreateDate(),
                food.getExpiryDate()) < Limit_100) {
            if (calculateInPercent(food.getCreateDate(),
                    food.getExpiryDate()) >= Limit_75) {
                food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            }
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }

    private double calculateInPercent(LocalDateTime createDate, LocalDateTime expiryDate) {
        return 0;
    }
}

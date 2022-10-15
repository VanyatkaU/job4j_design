package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final double limit25 = 25D;
    private final double limit75 = 75D;
    private final double limit100 = 100D;
    private final List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) >= limit25 && getPercentExpiry(food) < limit75) {
            shop.add(food);
            rsl = true;
        }
        if (getPercentExpiry(food) >= limit75 && getPercentExpiry(food) < limit100) {
            food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            shop.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getAllFood() {
        return List.copyOf(shop);
    }
}
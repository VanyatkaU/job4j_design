package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.ood.lsp.AbstractStore.getPercentExpiry;
import static ru.job4j.ood.lsp.Constants.*;

public class Shop implements Store {

    private final List<Food> shop = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (getPercentExpiry(food) >= LIMIT_25 && getPercentExpiry(food) < LIMIT_100) {
            if (getPercentExpiry(food) >= LIMIT_75) {
                food.setPrice(food.getPrice() * (1 - (food.getDiscount() / 100)));
            }
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
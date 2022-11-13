package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> storeList;

    public ControlQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void checkFood(Food food) {
        for (Store store : storeList) {
            if (store.add(food)) {
                break;
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Store store : storeList) {
            foods.addAll(store.getAllFood());
            store.clean();
        }
        for (Food food : foods) {
            checkFood(food);
        }
    }
}

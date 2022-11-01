package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.model.Food;

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
}

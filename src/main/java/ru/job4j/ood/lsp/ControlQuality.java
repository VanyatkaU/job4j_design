package ru.job4j.ood.lsp;

import java.util.List;

public class ControlQuality {

    private List<Store> storeList;

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
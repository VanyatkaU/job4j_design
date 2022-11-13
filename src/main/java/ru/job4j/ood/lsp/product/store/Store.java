package ru.job4j.ood.lsp.product.store;

import ru.job4j.ood.lsp.product.model.Food;

import java.util.List;

public interface Store {

    boolean add(Food food);

    List<Food> getAllFood();

    void clean();

}

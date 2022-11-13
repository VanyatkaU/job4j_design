package ru.job4j.ood.dip;

/**
 * Нарушение принципа DIP (Dependency Inversion Principle) - принципа инверсии зависимостей.
 *  * В данном случае существует жесткая привязка FoodDip к печати
 *  списка продуктов.
 */

import java.util.ArrayList;
import java.util.List;

public class PrintListFoodDip {

    public void print(FoodDip name) {
        List<String> foods = new ArrayList<>();
        if (!foods.isEmpty()) {
            System.out.println("List of foods " + name);
        }
    }
}

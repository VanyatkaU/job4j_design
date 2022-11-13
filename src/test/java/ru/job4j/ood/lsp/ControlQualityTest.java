package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.product.model.*;
import ru.job4j.ood.lsp.product.store.*;
import ru.job4j.ood.lsp.product.util.ExpirationCalculator;
import ru.job4j.ood.lsp.product.util.LocalDateTimeExpirationCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    ExpirationCalculator expirationCalculator = new LocalDateTimeExpirationCalculator();
    Store warehouse = new Warehouse(expirationCalculator);
    Store shop = new Shop(expirationCalculator);
    Store trash = new Trash(expirationCalculator);
    ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));

    @Test
    public void whenAllFoodOnControl() {
        Food bread = new Bread("хлеб", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(1),
                85.10, 10);
        Food cheese = new Cheese("сыр", LocalDateTime.now().plusDays(15), LocalDateTime.now().minusDays(8),
                250.00, 20);
        Food sausage = new Sausage("колбаса", LocalDateTime.now().plusDays(8), LocalDateTime.now().minusDays(15),
                350.00, 25);
        Food butter = new Butter("масло", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(20),
                185.00, 15);
        Food milk = new Milk("молоко", LocalDateTime.now().plusDays(5), LocalDateTime.now().minusDays(1),
                100.00, 12);
        controlQuality.checkFood(bread);
        controlQuality.checkFood(cheese);
        controlQuality.checkFood(sausage);
        controlQuality.checkFood(milk);
        controlQuality.checkFood(butter);
        assertThat(warehouse.getAllFood().containsAll(List.of(bread, milk)));
        assertThat(shop.getAllFood().containsAll(List.of(cheese, sausage)));
        assertThat(trash.getAllFood().contains(butter));
    }

    @Test
    public void whenAllFoodOnControlAndResort() {
        Food bread = new Bread("хлеб", LocalDateTime.now().plusDays(10), LocalDateTime.now().minusDays(1),
                85.10, 10);
        Food cheese = new Cheese("сыр", LocalDateTime.now().plusDays(15), LocalDateTime.now().minusDays(8),
                250.00, 20);
        Food sausage = new Sausage("колбаса", LocalDateTime.now().plusDays(8), LocalDateTime.now().minusDays(15),
                350.00, 25);
        Food butter = new Butter("масло", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(20),
                185.00, 15);
        Food milk = new Milk("молоко", LocalDateTime.now().plusDays(5), LocalDateTime.now().minusDays(1),
                100.00, 12);
        controlQuality.resort();
        assertThat(warehouse.getAllFood().containsAll(List.of(bread, milk)));
        assertThat(shop.getAllFood().containsAll(List.of(cheese, sausage)));
        assertThat(trash.getAllFood().contains(butter));
    }
}

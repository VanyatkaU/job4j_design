package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.*;
import ru.job4j.ood.lsp.store.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    Store warehouse = new Warehouse();
    Store shop = new Shop();
    Store trash = new Trash();
    ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));

    @Test
    public void whenPercentExpiryLess25() {
        LocalDateTime expired = LocalDateTime.now().plusDays(10);
        LocalDateTime created = LocalDateTime.now().minusDays(1);
        Food bread = new Bread("хлеб", expired, created, 85.00, 10.0);
        controlQuality.checkFood(bread);
        assertThat(warehouse.getAllFood()).contains(bread);
    }

    @Test
    public void whenPercentExpiryMore25AndLess75() {
        LocalDateTime expired = LocalDateTime.now().plusDays(15);
        LocalDateTime created = LocalDateTime.now().minusDays(8);
        Food cheese = new Cheese("сыр", expired, created, 250.50, 20);
        controlQuality.checkFood(cheese);
        assertThat(shop.getAllFood()).contains(cheese);
    }

    @Test
    public void whenPercentExpiryMore75AndDoDiscount() {
        LocalDateTime expired = LocalDateTime.now().plusDays(8);
        LocalDateTime created = LocalDateTime.now().minusDays(15);
        Food sausage = new Sausage("колбаса", expired, created, 350.0, 25);
        controlQuality.checkFood(sausage);
        assertThat(shop.getAllFood()).contains(sausage);
        assertThat(shop.getAllFood().get(0).getPrice() * (1 - (sausage.getDiscount() / 100))).isEqualTo(262.50);
    }

    @Test
    public void whenPercentExpiryEqualsOrMore100() {
        LocalDateTime expired = LocalDateTime.now().minusDays(1);
        LocalDateTime created = LocalDateTime.now().minusDays(20);
        Food butter = new Butter("масло", expired, created, 185.00, 15.0);
        controlQuality.checkFood(butter);
        assertThat(trash.getAllFood()).contains(butter);
    }

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
        assertThat(warehouse.getAllFood()).containsAll(List.of(bread, milk));
        assertThat(shop.getAllFood()).containsAll(List.of(cheese, sausage));
        assertThat(trash.getAllFood()).contains(butter);
    }
}

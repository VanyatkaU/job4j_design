package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Bread;
import ru.job4j.ood.lsp.model.Cheese;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;
import ru.job4j.ood.lsp.util.LocalDateTimeExpirationCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {

    ExpirationCalculator expirationCalculator = new LocalDateTimeExpirationCalculator();
    Store warehouse = new Warehouse(expirationCalculator);
    ControlQuality controlQuality = new ControlQuality(List.of(warehouse));

    @Test
    public void whenPercentExpiryLess25() {
        LocalDateTime expired = LocalDateTime.now().plusDays(10);
        LocalDateTime created = LocalDateTime.now().minusDays(1);
        Food bread = new Bread("хлеб", expired, created, 85.00, 10.0);
        controlQuality.checkFood(bread);
        assertThat(warehouse.getAllFood().contains(bread));
    }

}
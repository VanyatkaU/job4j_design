package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Cheese;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.model.Sausage;
import ru.job4j.ood.lsp.util.ExpirationCalculator;
import ru.job4j.ood.lsp.util.LocalDateTimeExpirationCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    ExpirationCalculator expirationCalculator = new LocalDateTimeExpirationCalculator();
    Store shop = new Shop(expirationCalculator);
    ControlQuality controlQuality = new ControlQuality(List.of(shop));

    @Test
    public void whenPercentExpiryMore25AndLess75() {
        LocalDateTime expired = LocalDateTime.now().plusDays(15);
        LocalDateTime created = LocalDateTime.now().minusDays(8);
        Food cheese = new Cheese("сыр", expired, created, 250.50, 20);
        controlQuality.checkFood(cheese);
        assertThat(shop.getAllFood().contains(cheese));
    }

    @Test
    public void whenPercentExpiryMore75AndDoDiscount() {
        LocalDateTime expired = LocalDateTime.now().plusDays(8);
        LocalDateTime created = LocalDateTime.now().minusDays(15);
        Food sausage = new Sausage("колбаса", expired, created, 350.0, 25);
        controlQuality.checkFood(sausage);
        assertThat(shop.getAllFood().contains(sausage));
        assertThat(sausage.getPrice() * (1 - (sausage.getDiscount() / 100))).isEqualTo(262.50);
    }

}

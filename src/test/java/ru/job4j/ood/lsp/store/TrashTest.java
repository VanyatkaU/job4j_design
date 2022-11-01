package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.model.Butter;
import ru.job4j.ood.lsp.model.Food;
import ru.job4j.ood.lsp.util.ExpirationCalculator;
import ru.job4j.ood.lsp.util.LocalDateTimeExpirationCalculator;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {

    ExpirationCalculator expirationCalculator = new LocalDateTimeExpirationCalculator();
    Store trash = new Trash(expirationCalculator);
    ControlQuality controlQuality = new ControlQuality(List.of(trash));

    @Test
    public void whenPercentExpiryEqualsOrMore100() {
        LocalDateTime expired = LocalDateTime.now().minusDays(1);
        LocalDateTime created = LocalDateTime.now().minusDays(20);
        Food butter = new Butter("масло", expired, created, 185.00, 15.0);
        controlQuality.checkFood(butter);
        assertThat(trash.getAllFood().contains(butter));
    }
}

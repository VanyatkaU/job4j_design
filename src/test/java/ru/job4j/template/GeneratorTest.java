package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class GeneratorTest {

    @Test
    void whenCorrectProduce() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("subject", "you");
        assertThat(generator.produce("I am ${name}, Who are ${subject}", map))
                .isEqualTo("I am a Ivan, Who are you");
    }

    @Test
    void whenIncorrectKey() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("surname", "Ivan");
        map.put("subject", "you");
        assertThrows(IllegalArgumentException.class, () ->
            generator.produce("I am ${name}, Who are ${subject}", map)
        );
    }

    @Test
    void whenTooMoreKeys() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivan");
        map.put("surname", "Karelkin");
        map.put("subject", "you");
        assertThrows(IllegalArgumentException.class, () ->
                generator.produce("I am ${name}, Who are ${subject}", map)
        );
    }

    @Test
    void whenIncorrectMap() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () ->
                generator.produce("I am ${name}, Who are ${subject}", map)
        );
    }

}
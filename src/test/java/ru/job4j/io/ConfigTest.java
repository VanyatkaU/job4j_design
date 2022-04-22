package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan=1"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan"));
        assertThat(config.value("surname"), is("Karelkin"));
    }

    @Test
    public void whenPairWithComments() {
        String path = "./data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Ivan"));
        assertThat(config.value("surname"), is("Karelkin"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithViolationKey() {
        String path = "./data/pair_violation_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithViolationValue() {
        String path = "./data/pair_violation_value.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithViolationWithoutEquals() {
        String path = "./data/pair_violation_without_equals.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenPairWithViolationWithoutValues() {
        String path = "./data/pair_violation_without_values.properties";
        Config config = new Config(path);
        config.load();
    }
}
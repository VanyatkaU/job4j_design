package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {

    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void  checkMessageParse() {
        NameLoad nameLoad = new NameLoad();
        String names = "";
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void  checkWordMessageParse() {
        NameLoad nameLoad = new NameLoad();
        String word = "Names";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word)
                .hasMessageContaining("Names");
    }

    @Test
    void  checkMessageValidate() {
        NameLoad nameLoad = new NameLoad();
        String name = "";
        assertThatThrownBy(() -> nameLoad.parse(name))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void checkValidateSymbol() {
        NameLoad nameLoad = new NameLoad();
        String word = "name";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word)
                .hasMessageContaining("does not contain the symbol \"=\"");
    }

    @Test
    void checkValidateKey() {
        NameLoad nameLoad = new NameLoad();
        String word = "=name";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word)
                .hasMessageContaining("does not contain a key");
    }

    @Test
    void checkValidateValue() {
        NameLoad nameLoad = new NameLoad();
        String word = "name=";
        assertThatThrownBy(() -> nameLoad.parse(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("^.+")
                .hasMessageContaining(word)
                .hasMessageContaining("does not contain a value");
    }
}
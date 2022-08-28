package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(4, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void theNumberOfVerticesEqualsTo8() {
        Box box = new Box(8, 1);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(8);
    }

    @Test
    void theNumberOfVerticesEqualsTo0() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0);
    }

    @Test
    void isExist() {
        Box box = new Box(4, 1);
        boolean vertex = box.isExist();
        assertThat(vertex).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(-1, 0);
        boolean vertex = box.isExist();
        assertThat(vertex).isFalse();
    }

    @Test
    void areaIsCube() {
        Box box = new Box(8, 6);
        double rsl = box.getArea();
        assertThat(rsl).isCloseTo(216.0d,
                Percentage.withPercentage(0.01)).isNotZero();
    }

    @Test
    void areaIsZero() {
        Box box = new Box(0, 0);
        double rsl = box.getArea();
        assertThat(rsl).isZero();
    }
}

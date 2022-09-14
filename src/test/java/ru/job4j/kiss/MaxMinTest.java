package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    private static int compare(Integer o1, Integer o2) {
        return Integer.compare(o1.compareTo(o2), 0);
    }

    @Test
    public void maxTest() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = Arrays.asList(0, -24, 56, 3, -9, 2, 235, 17);
        int max = maxMin.max(list, Integer::compareTo);
        assertThat(max, is(235));
    }

    @Test
    public void minTest() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = Arrays.asList(0, -24, 56, 3, -9, 2, 235, 17);
        int min = maxMin.min(list, Integer::compareTo);
        assertThat(min, is(-24));
    }

    @Test
    public void nullTest() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = new ArrayList<>();
        Comparator<Integer> comparator = (MaxMinTest::compare);
        assertNull(maxMin.max(list, comparator));
        assertNull(maxMin.min(list, comparator));
    }
}

package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

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
}
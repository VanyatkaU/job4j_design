package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, Is.is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 3, 2);
    }


    @Test
    public void whenRemoveIfValueZero() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input, v -> v == 0);
        assertThat(input, Is.is(Arrays.asList(1, 2)));
    }

    @Test
    public void whenReplaceIfIndexMore3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5));
        ListUtils.replaceIf(input, v -> v > 3, 4);
        assertThat(input, Is.is(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void whenRemoveAllElements() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(0, 4, 5)));
        assertThat(input, Is.is(Arrays.asList(1, 2, 3)));
    }
}

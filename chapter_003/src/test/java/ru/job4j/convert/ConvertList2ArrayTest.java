package ru.job4j.convert;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList2ArrayTest {
    private ConvertList2Array list;

    @Before
    public void init() {
        this.list = new ConvertList2Array();
    }
    /**
     * 7 elements 3 rows
     */
    @Test
    public void when7ElementsThen9() {
        int[][] result = this.list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * 8 elements 3 rows
     */
    @Test
    public void when8ElementsThen9() {
        int[][] result = this.list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * 9 elements 3 rows
     */
    @Test
    public void when9Elements3rowThen9() {
        int[][] result = this.list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertThat(result, is(expect));
    }
    /**
     * 7 elements 4 rows
     */
    @Test
    public void when7Elements2rowThenTall8() {
        int[][] result = this.list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 0}
        };
        assertThat(result, is(expect));
    }
    /**
     * 7 elements 2 rows
     */
    @Test
    public void when7Elements2rowThenLong8() {
        int[][] result = this.list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                2
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 0}
        };
        assertThat(result, is(expect));
    }

    /**
     * Input arrays' lengths - 1, 3, 2.
     */
    @Test
    public void when1And3And2ArraysListThenList6() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {1});
        input.add(new int[] {2, 3, 4});
        input.add(new int[] {5, 6});
        assertThat(this.list.convert(input), is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
    /**
     * One of the input arrays is empty.
     */
    @Test
    public void whenOneOfArraysEmptyListThenListWithoutEmpty() {
        List<int[]> input = new ArrayList<>();
        input.add(new int[] {});
        input.add(new int[] {1, 2});
        assertThat(this.list.convert(input), is(Arrays.asList(1, 2)));
    }
}

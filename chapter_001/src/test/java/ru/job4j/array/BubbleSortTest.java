package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.02.2019
 */
public class BubbleSortTest {
    /**
     * Test ten elements
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] result = bubbleSort.sort(array);
        assertThat(result, is(expect));
    }
    /**
     * Test two elements
     */
    @Test
    public void whenArrayWithTwoElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[] {2, 1};
        int[] expect = new int[] {1, 2};
        int[] result = bubbleSort.sort(array);
        assertThat(result, is(expect));
    }

}

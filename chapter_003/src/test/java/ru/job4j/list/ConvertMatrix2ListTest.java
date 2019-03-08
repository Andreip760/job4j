package ru.job4j.list;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;
/**
 * Test
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.03.2019
 */
public class ConvertMatrix2ListTest {
    /**
     * Converting 2 x 2 array
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
    /**
     * Converting an empty array
     */
    @Test
    public void whenEmptyOn2ArrayThenEmptyList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {{}, {}};
        List<Integer> expect = Arrays.asList();
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}

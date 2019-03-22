package ru.job4j.matrix;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.03.2019
 */
public class MatrixConverterTest {
    /**
     * Converting 2x2 matrix.
     */
    @Test
    public void when2Row2ColMatrixThenListOf4() {
        Integer[][] matrix = {{1, 2}, {3, 4}};
        assertThat(new MatrixConverter().convertMatrix(matrix), is(Arrays.asList(1, 2, 3, 4)));
    }
    /**
     * Converting empty 2x2 matrix.
     */
    @Test
    public void whenEmptyMatrixThenEmptyList() {
        Integer[][] matrix = new Integer[0][0];
        assertThat(new MatrixConverter().convertMatrix(matrix), is(Collections.EMPTY_LIST));
    }
}

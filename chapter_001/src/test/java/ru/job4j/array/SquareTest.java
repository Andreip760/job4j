package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class SquareTest {
    /**
     * Test bound 3.
     */
    @Test
    public void whenBound3Then149() {
        Square square = new Square();
        int bound = 3;
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(result, is(expect));
    }
    /**
     * Test bound 0.
     */
    @Test
    public void whenBound0ThenEmptyArray() {
        Square square = new Square();
        int bound = 0;
        int[] result = square.calculate(bound);
        int[] expect = new int[0];
        assertThat(result, is(expect));
    }
    /**
     * Test bound 1.
     */
    @Test
    public void whenBound1Then1() {
        Square square = new Square();
        int bound = 1;
        int[] result = square.calculate(bound);
        int[] expect = new int[] {1};
        assertThat(result, is(expect));
    }
}

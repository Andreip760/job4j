package ru.job4j.maths;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 17.03.2019
 */
public class MathLoopTest {
    private final MathLoop mathLoop = new MathLoop();
    /**
     * Linear function 2x + 1. X range 5 - 8.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = mathLoop.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    /**
     * Logarithm function. Base 2. X range 2 - 6.
     */
    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = mathLoop.diapason(
                2, 6, x -> Math.round(Math.log(x) / Math.log(2) * 100D) / 100D);
        List<Double> expected = Arrays.asList(1D, 1.58D, 2D, 2.32D);
        assertThat(result, is(expected));
    }
    /**
     * Square function 2x^2 + 2x + 1. X range 2 - 5.
     */
    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result = mathLoop.diapason(2, 5, x -> 2 * Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(13D, 25D, 41D);
        assertThat(result, is(expected));
    }
}

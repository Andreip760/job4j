package ru.job4j.functional;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 15.03.2019
 */
public class CalculatorTest {
    /**
     * Subtraction function (value - 0, indexes - 1 to 3)
     */
    @Test
    public void whenSubtract1Until4() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                1, 4, 0,
                (value, index) -> (double) value - index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(-1D, -2D, -3D)));
    }
    /**
     * Adding function (value - 1, indexes - 0 to 3)
     */
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    /**
     * Adding function by calling a method (value - 1, indexes - 0 to 3)
     */
    @Test
    public void whenAdd1Until3MethodCall() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                MathUtil::add,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
    /**
     * Dividing function by calling a method (value - 10, indexes - 1 to 4)
     */
    @Test
    public void whenDiv2Until4MethodCall() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                1, 4, 10,
                MathUtil::div,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(10D, 5D, 3D)));
    }
}

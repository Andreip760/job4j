package ru.job4j.functional;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Class testing using functional interfaces and lambda expressions.
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
}

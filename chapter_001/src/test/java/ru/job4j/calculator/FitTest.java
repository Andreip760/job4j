package ru.job4j.calculator;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 07.02.2019
 */
public class FitTest {
    /**
     * Test ideal man weight
     */
    @Test
    public void whenManHeight180ThenClose92() {
        Fit fit = new Fit();
        double result = fit.manWeight(180D);
        assertThat(result, closeTo(92.0D, 0.1D));
    }
    /**
     * Test ideal woman weight
     */
    @Test
    public void whenWomanHeight170ThenClose69() {
        Fit fit = new Fit();
        double result = fit.womanWeight(170D);
        assertThat(result, closeTo(69.0D, 0.1D));
    }
}

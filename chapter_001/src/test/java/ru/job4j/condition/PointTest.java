package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.02.2019
 */
public class PointTest {
    /**
     * Test
     * point a: X = 0; Y = 1
     * point b: X = 2; Y = 5
     * expect: close to 4.5
     */
    @Test
    public void pointToPointDistanceTest() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(4.5D, 0.1D));
    }
}

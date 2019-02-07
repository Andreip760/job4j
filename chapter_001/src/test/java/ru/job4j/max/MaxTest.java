package ru.job4j.max;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 06.02.2019
 */
public class MaxTest {
    /**
     * Test 1 & 2
     */
    @Test
    public void whenFirstLessSecondThenSecond() {
        Max max = new Max();
        assertThat(max.max(1, 2), is(2));
    }
    /**
     * Test 2 & 1
     */
    @Test
    public void whenFirstBiggerSecond1ThenFirst() {
        Max max = new Max();
        assertThat(max.max(2, 1), is(2));
    }
}

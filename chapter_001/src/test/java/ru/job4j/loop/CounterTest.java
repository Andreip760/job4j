package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Andrei Pashchenko
 * @version 1
 * @since 08.02.2019
 */
public class CounterTest {
    /**
     * Sum of even numbers from 1 to 10 (inclusive).
     * expect 30.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
       Counter counter = new Counter();
       int result = counter.add(1, 10);
       assertThat(result, is(30));
    }
}

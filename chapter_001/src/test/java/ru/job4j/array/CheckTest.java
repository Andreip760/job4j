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
public class CheckTest {
    /**
     * Test mono (odd amount)
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test not mono (odd amount)
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test mono (even amount)
     */
    @Test
    public void whenDataMonoByFalseAndEvenAmountThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test not mono (even amount)
     */
    @Test
    public void whenDataNotMonoByTrueAndEvenAmountThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}

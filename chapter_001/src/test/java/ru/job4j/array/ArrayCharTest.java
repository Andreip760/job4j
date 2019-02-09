package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 09.02.2019
 */
public class ArrayCharTest {
    /**
     * Word starts with prefix
     */
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }
    /**
     * Word doesn't starts with prefix
     */
    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }
    /**
     * Word and prefix have the same length and equal
     */
    @Test
    public void whenPrefixSameAsInputThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hello");
        assertThat(result, is(true));
    }
    /**
     * Prefix is longer than word
     */
    @Test
    public void whenPrefixLongerInputThenFalse() {
        ArrayChar word = new ArrayChar("He");
        boolean result = word.startWith("Hel");
        assertThat(result, is(false));
    }
}
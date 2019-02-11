package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.02.2019
 */
public class MatrixCheckTest {
    /**
     * Test odd amount, mono-True.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test odd amount, not mono.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test even amount, mono true and false
     */
    @Test
    public void whenEvenSizeAndDataMonoByTrueAndFalseThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, false},
                {false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test even amount, not mono
     */
    @Test
    public void whenEvenSizeAndDataNotMonoThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][] {
                {true, true},
                {false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}

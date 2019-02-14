package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class PaintTest {
    /**
     * Test a right half.
     * height 4.
     */
    @Test
    public void whenPyramid4Right() {
        Paint paint = new Paint();
        String result = paint.rightTrl(4);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^   ")
                                .add("^^  ")
                                .add("^^^ ")
                                .add("^^^^")
                                .toString()
                )
        );
    }
    /**
     * Test a left half.
     * height 4.
     */
    @Test
    public void whenPyramid4Left() {
        Paint paint = new Paint();
        String result = paint.leftTrl(4);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^")
                                .add("  ^^")
                                .add(" ^^^")
                                .add("^^^^")
                                .toString()
                )
        );
    }
    /**
     * Test a pyramid.
     * height 3.
     */
    @Test
    public void whenPyramid3() {
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^^^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }
    /**
     * Test a pyramid.
     * height 4.
     */
    @Test
    public void whenPyramid4() {
        Paint paint = new Paint();
        String result = paint.pyramid(4);
        assertThat(result,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("   ^   ")
                                .add("  ^^^  ")
                                .add(" ^^^^^ ")
                                .add("^^^^^^^")
                                .toString()
                )
        );
    }
}

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
public class BoardTest {
    /**
     * Test 3x3 board
     */
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String separator = System.getProperty("line.separator");
        String expected = String.format("x x%s x %sx x%s", separator, separator, separator);
        assertThat(result, is(expected));
    }
    /**
     * Test 5x4 board
     */
    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board = new Board();
        String result = board.paint(5, 4);
        final String separator = System.getProperty("line.separator");
        String expected = String.format("x x x%s x x %sx x x%s x x %s", separator, separator, separator, separator);
        assertThat(result, is(expected));
    }
}

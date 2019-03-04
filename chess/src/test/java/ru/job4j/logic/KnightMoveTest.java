package ru.job4j.logic;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KnightBlack;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 01.03.2019
 */
public class KnightMoveTest {
    private Logic logic;
    private final Cell source = Cell.D5;
    /**
     * Creating the Knight on the board
     */
    @Before
    public void before() {
        this.logic = new Logic();
        this.logic.add(new KnightBlack(Cell.D5));
    }
    /**
     * Trying to move up-right (scheme X 1 : Y 2)
     */
    @Test
    public void whenMoveCorrectUpRightX1Y2ThenTrue() {
        assertThat(this.logic.move(this.source, Cell.E3), is(true));
    }
    /**
     * Trying to jump over figure
     */
    @Test
    public void whenJumpOverThenTrue() {
        this.logic.add(new KnightBlack(Cell.E2));
        assertThat(this.logic.move(this.source, Cell.E3), is(true));
    }
    /**
     * Trying to move to occupied cell
     */
    @Test
    public void whenMoveToOccupiedThenFalse() {
        this.logic.add(new KnightBlack(Cell.E3));
        assertThat(this.logic.move(this.source, Cell.E3), is(false));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenMoveIncorrectThenFalse() {
        assertThat(this.logic.move(this.source, Cell.B7), is(false));
    }
}

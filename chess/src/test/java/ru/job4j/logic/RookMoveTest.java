package ru.job4j.logic;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.RookBlack;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 01.03.2019
 */
public class RookMoveTest {
    private Logic logic;
    private final Cell source = Cell.D5;
    /**
     * Creating the Rook on the board
     */
    @Before
    public void before() {
        this.logic = new Logic();
        this.logic.add(new RookBlack(Cell.D5));
    }
    /**
     * Moving correctly up
     */
    @Test
    public void whenMoveUpFreeWayThenSuccess() {
        assertThat(this.logic.move(this.source, Cell.D1), is(true));
    }
    /**
     * Trying to jump over the second figure
     */
    @Test
    public void whenJumpOverFigureThenFail() {
        this.logic.add(new RookBlack(Cell.D2));
        assertThat(this.logic.move(this.source, Cell.D1), is(false));
    }
    /**
     * Trying to move to the occupied cell
     */
    @Test
    public void whenMoveToOccupiedCellThenFail() {
        this.logic.add(new RookBlack(Cell.D1));
        assertThat(this.logic.move(this.source, Cell.D1), is(false));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenIncorrectMoveThenFail() {
        assertThat(this.logic.move(this.source, Cell.E6), is(false));
    }
}

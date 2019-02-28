package ru.job4j;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 01.03.2019
 */
public class BishopMoveTest {
    Logic logic;

    /**
     * Creating the Bishop on the board
     */
    @Before
    public void before() {
        logic = new Logic();
        logic.add(new BishopBlack(Cell.D5));
    }
    /**
     * Moving correctly to the right-up
     */
    @Test
    public void whenMoveRightUpFreeWayThenSuccess() {
        assertThat(this.logic.move(Cell.D5, Cell.F3), is(true));
    }
    /**
     * Moving correctly to the left-up
     */
    @Test
    public void whenMoveLeftUpFreeWayThenSuccess() {
        assertThat(this.logic.move(Cell.D5, Cell.B3), is(true));
    }
    /**
     * Moving correctly to the right-down
     */
    @Test
    public void whenMoveRightDownFreeWayThenSuccess() {
        assertThat(this.logic.move(Cell.D5, Cell.F7), is(true));
    }
    /**
     * Moving correctly to the left-down
     */
    @Test
    public void whenMoveLeftDownFreeWayThenSuccess() {
        assertThat(this.logic.move(Cell.D5, Cell.C6), is(true));
    }
    /**
     * Trying to jump over the second figure
     */
    @Test
    public void whenJumpOverFigureThenFail() {
        this.logic.add(new BishopBlack(Cell.B7));
        assertThat(this.logic.move(Cell.D5, Cell.A8), is(false));
    }
    /**
     * Trying to do the incorrect movement
     */
    @Test
    public void whenIncorrectMoveThenFail() {
        assertThat(this.logic.move(Cell.D5, Cell.D8), is(false));
    }
}

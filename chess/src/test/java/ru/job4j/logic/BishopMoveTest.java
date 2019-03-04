package ru.job4j.logic;
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
    private Logic logic;
    private final Cell source = Cell.D5;
    /**
     * Creating the Bishop on the board
     */
    @Before
    public void before() {
        this.logic = new Logic();
        this.logic.add(new BishopBlack(Cell.D5));
    }
    /**
     * Moving correctly to the right-up
     */
    @Test
    public void whenMoveRightUpFreeWayThenSuccess() {
        assertThat(this.logic.move(this.source, Cell.F3), is(true));
    }
     /**
     * Trying to jump over the second figure
     */
    @Test
    public void whenJumpOverFigureThenFail() {
        this.logic.add(new BishopBlack(Cell.B7));
        assertThat(this.logic.move(this.source, Cell.A8), is(false));
    }
    /**
     * Trying to move to the occupied cell
     */
    @Test
    public void whenMoveToOccupiedCellThenFail() {
        this.logic.add(new BishopBlack(Cell.A8));
        assertThat(this.logic.move(this.source, Cell.A8), is(false));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenIncorrectMoveThenFail() {
        assertThat(this.logic.move(this.source, Cell.D8), is(false));
    }
}

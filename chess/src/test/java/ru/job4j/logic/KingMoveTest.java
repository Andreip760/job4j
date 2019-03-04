package ru.job4j.logic;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KingBlack;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 01.03.2019
 */
public class KingMoveTest {
    private Logic logic;
    private final Cell source = Cell.D5;
    /**
     * Creating the King on the board
     */
    @Before
    public void before() {
        this.logic = new Logic();
        this.logic.add(new KingBlack(Cell.D5));
    }
    /**
     * Moving correctly up
     */
    @Test
    public void whenMoveUpFreeWayThenSuccess() {
        assertThat(this.logic.move(this.source, Cell.D4), is(true));
    }
    /**
     * Trying to move to the occupied cell
     */
    @Test
    public void whenMoveToOccupiedCellThenFail() {
        this.logic.add(new KingBlack(Cell.D6));
        assertThat(this.logic.move(this.source, Cell.D6), is(false));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenIncorrectMoveThenFail() {
        assertThat(this.logic.move(this.source, Cell.D7), is(false));
    }
}

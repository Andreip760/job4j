package ru.job4j.logic;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.PawnWhite;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 01.03.2019
 */
public class WhitePawnMoveTest {
    private Logic logic;
    private final Cell source = Cell.D5;
    /**
     * Creating the Pawn (white) on the board
     */
    @Before
    public void before() {
        this.logic = new Logic();
        this.logic.add(new PawnWhite(Cell.D5));
    }
    /**
     * Moving correctly down
     */
    @Test
    public void whenMoveDownFreeWayThenSuccess() {
        assertThat(this.logic.move(this.source, Cell.D6), is(true));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenMoveUpThenFail() {
        assertThat(this.logic.move(this.source, Cell.D4), is(false));
    }
    /**
     * Trying to move to the occupied cell
     */
    @Test
    public void whenMoveToOccupiedCellThenFail() {
        this.logic.add(new BishopBlack(Cell.D6));
        assertThat(this.logic.move(this.source, Cell.D6), is(false));
    }
}

package ru.job4j.routers;
import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.QeenBlack;
import ru.job4j.chess.firuges.routers.Router;
import ru.job4j.chess.firuges.routers.RouterFactory;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class QueenRouterTest {
    private final Router router = RouterFactory.getInstance().getRouter(new QeenBlack(Cell.A1));
    private final Cell source = Cell.D5;
    /**
     * Trying to move up
     */
    @Test
    public void whenMoveCorrectUpThenRoute() {
        Cell[] expect = {Cell.D4, Cell.D3};
        assertThat(this.router.getRoute(this.source, Cell.D3), arrayContaining(expect));
    }
    /**
     * Trying to move up-right
     */
    @Test
    public void whenMoveCorrectUpRightThenRoute() {
        Cell[] expect = {Cell.E4, Cell.F3};
        assertThat(this.router.getRoute(this.source, Cell.F3), arrayContaining(expect));
    }
    /**
     * Trying to move up-left
     */
    @Test
    public void whenMoveCorrectUpLeftThenRoute() {
        Cell[] expect = {Cell.C4, Cell.B3};
        assertThat(this.router.getRoute(this.source, Cell.B3), arrayContaining(expect));
    }
    /**
     * Trying to move down
     */
    @Test
    public void whenMoveCorrectDownThenRoute() {
        Cell[] expect = {Cell.D6, Cell.D7};
        assertThat(this.router.getRoute(this.source, Cell.D7), arrayContaining(expect));
    }
    /**
     * Trying to move down-right
     */
    @Test
    public void whenMoveCorrectDownRightThenRoute() {
        Cell[] expect = {Cell.E6, Cell.F7};
        assertThat(this.router.getRoute(this.source, Cell.F7), arrayContaining(expect));
    }
    /**
     * Trying to move down-left
     */
    @Test
    public void whenMoveCorrectDownLeftThenRoute() {
        Cell[] expect = {Cell.C6, Cell.B7};
        assertThat(this.router.getRoute(this.source, Cell.B7), arrayContaining(expect));
    }
    /**
     * Trying to move right
     */
    @Test
    public void whenMoveCorrectRightThenRoute() {
        Cell[] expect = {Cell.E5, Cell.F5};
        assertThat(this.router.getRoute(this.source, Cell.F5), arrayContaining(expect));
    }
    /**
     * Trying to move left
     */
    @Test
    public void whenMoveCorrectLeftThenRoute() {
        Cell[] expect = {Cell.C5, Cell.B5};
        assertThat(this.router.getRoute(this.source, Cell.B5), arrayContaining(expect));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenMoveIncorrectThenEmptyRoute() {
        Cell[] expect = {};
        assertThat(this.router.getRoute(this.source, Cell.F4), is(expect));
    }
}

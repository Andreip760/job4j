package ru.job4j.routers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KnightBlack;
import ru.job4j.chess.firuges.routers.Router;
import ru.job4j.chess.firuges.routers.RouterFactory;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class KnightRouterTest {
    private final Router router = RouterFactory.getInstance().getRouter(KnightBlack.class.getSimpleName());
    private final Cell source = Cell.D5;
    /**
     * Trying to move up-right (scheme X 1 : Y 2)
     */
    @Test
    public void whenMoveCorrectUpRightX1Y2ThenRoute() {
        Cell[] expect = {Cell.E5, Cell.E4, Cell.E3};
        assertThat(this.router.getRoute(this.source, Cell.E3), arrayContaining(expect));
    }
    /**
     * Trying to move up-right (scheme X 2 : Y 1)
     */
    @Test
    public void whenMoveCorrectUpRightX2Y1ThenRoute() {
        Cell[] expect = {Cell.E5, Cell.F5, Cell.F4};
        assertThat(this.router.getRoute(this.source, Cell.F4), arrayContaining(expect));
    }
    /**
     * Trying to move up-left (scheme X 1 : Y 2)
     */
    @Test
    public void whenMoveCorrectUpLeftX1Y2ThenRoute() {
        Cell[] expect = {Cell.C5, Cell.C4, Cell.C3};
        assertThat(this.router.getRoute(this.source, Cell.C3), arrayContaining(expect));
    }
    /**
     * Trying to move up-left (scheme X 2 : Y 1)
     */
    @Test
    public void whenMoveCorrectUpLeftX2Y1ThenRoute() {
        Cell[] expect = {Cell.C5, Cell.B5, Cell.B4};
        assertThat(this.router.getRoute(this.source, Cell.B4), arrayContaining(expect));
    }
    /**
     * Trying to move down-right (scheme X 1 : Y 2)
     */
    @Test
    public void whenMoveCorrectDownRightX1Y2ThenRoute() {
        Cell[] expect = {Cell.E5, Cell.E6, Cell.E7};
        assertThat(this.router.getRoute(this.source, Cell.E7), is(expect));
    }
    /**
     * Trying to move down-right (scheme X 2 : Y 1)
     */
    @Test
    public void whenMoveCorrectDownRightX2Y1ThenRoute() {
        Cell[] expect = {Cell.E5, Cell.F5, Cell.F6};
        assertThat(this.router.getRoute(this.source, Cell.F6), is(expect));
    }
    /**
     * Trying to move down-left (scheme X 1 : Y 2)
     */
    @Test
    public void whenMoveCorrectDownLeftX1Y2ThenRoute() {
        Cell[] expect = {Cell.C5, Cell.C6, Cell.C7};
        assertThat(this.router.getRoute(this.source, Cell.C7), is(expect));
    }
    /**
     * Trying to move down-left (scheme X 2 : Y 1)
     */
    @Test
    public void whenMoveCorrectDownLeftX2Y1ThenRoute() {
        Cell[] expect = {Cell.C5, Cell.B5, Cell.B6};
        assertThat(this.router.getRoute(this.source, Cell.B6), is(expect));
    }
    /**
     * Trying to move incorrectly
     */
    @Test
    public void whenMoveIncorrectThenEmptyRoute() {
        Cell[] expect = {};
        assertThat(this.router.getRoute(this.source, Cell.B7), is(expect));
    }
}

package ru.job4j.routers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.routers.Router;
import ru.job4j.chess.firuges.routers.RouterFactory;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class BishopRouterTest {
    private final Router router = RouterFactory.getInstance().getRouter(BishopBlack.class.getSimpleName());
    private final Cell source = Cell.D5;
    /**
     * Trying to move up-right
     */
    @Test
    public void whenMoveCorrectUpRightThenRoute() {
        Cell[] expect = {Cell.E4, Cell.F3};
        assertThat(this.router.getRoute(this.source, Cell.F3), arrayContaining(expect));
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
     * Trying to move up-left
     */
    @Test
    public void whenMoveCorrectUpLeftThenRoute() {
        Cell[] expect = {Cell.C4, Cell.B3};
        assertThat(this.router.getRoute(this.source, Cell.B3), arrayContaining(expect));
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
     * Trying to move incorrectly
     */
    @Test
    public void whenMoveIncorrectThenEmptyRoute() {
        Cell[] expect = {};
        assertThat(this.router.getRoute(this.source, Cell.D7), is(expect));
    }
}

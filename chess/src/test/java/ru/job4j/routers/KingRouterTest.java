package ru.job4j.routers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.KingBlack;
import ru.job4j.chess.firuges.routers.Router;
import ru.job4j.chess.firuges.routers.RouterFactory;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class KingRouterTest {
    private final Router router = RouterFactory.getInstance().getRouter(KingBlack.class.getSimpleName());
    private final Cell source = Cell.D5;
    /**
     * Trying to move up
     */
    @Test
    public void whenMoveCorrectUpThenRoute() {
        Cell[] expect = {Cell.D4};
        assertThat(this.router.getRoute(this.source, Cell.D4), is(expect));
    }
    /**
     * Trying to move up-right
     */
    @Test
    public void whenMoveCorrectUpRightThenRoute() {
        Cell[] expect = {Cell.E4};
        assertThat(this.router.getRoute(this.source, Cell.E4), is(expect));
    }
    /**
     * Trying to move up-left
     */
    @Test
    public void whenMoveCorrectUpLeftThenRoute() {
        Cell[] expect = {Cell.C4};
        assertThat(this.router.getRoute(this.source, Cell.C4), is(expect));
    }
    /**
     * Trying to move down
     */
    @Test
    public void whenMoveCorrectDownThenRoute() {
        Cell[] expect = {Cell.D6};
        assertThat(this.router.getRoute(this.source, Cell.D6), is(expect));
    }
    /**
     * Trying to move down-right
     */
    @Test
    public void whenMoveCorrectDownRightThenRoute() {
        Cell[] expect = {Cell.E6};
        assertThat(this.router.getRoute(this.source, Cell.E6), is(expect));
    }
    /**
     * Trying to move down-left
     */
    @Test
    public void whenMoveCorrectDownLeftThenRoute() {
        Cell[] expect = {Cell.C6};
        assertThat(this.router.getRoute(this.source, Cell.C6), is(expect));
    }
    /**
     * Trying to move left
     */
    @Test
    public void whenMoveCorrectLeftThenRoute() {
        Cell[] expect = {Cell.C5};
        assertThat(this.router.getRoute(this.source, Cell.C5), is(expect));
    }
    /**
     * Trying to move right
     */
    @Test
    public void whenMoveCorrectRightThenRoute() {
        Cell[] expect = {Cell.E5};
        assertThat(this.router.getRoute(this.source, Cell.E5), is(expect));
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

package ru.job4j.routers;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.routers.RouterFactory;
import ru.job4j.chess.firuges.white.KingWhite;

/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class RouterFactoryTest {
    private static final RouterFactory FACTORY = RouterFactory.getInstance();
    /**
     * Router FACTORY is a single instance
     */
    @Test
    public void whenTryCreateSecondFactoryThenSameInstance() {
        assertThat(RouterFactory.getInstance(), is(FACTORY));
    }
    /**
     * Trying to get a Bishop router
     */
    @Test
    public void whenAskForBishopRouterThenBishopRouterInstance() {
        assertThat(FACTORY.getRouter(BishopBlack.class.getSimpleName()).getClass().getSimpleName(), is("BishopRouter"));
    }
    /**
     * Trying to get a King router (testing for white)
     */
    @Test
    public void whenAskForKingRouterThenKingRouterInstance() {
        assertThat(FACTORY.getRouter(KingWhite.class.getSimpleName()).getClass().getSimpleName(), is("KingRouter"));
    }
    /**
     * Trying to get a Knight router
     */
    @Test
    public void whenAskForKnightRouterThenKnightRouterInstance() {
        assertThat(FACTORY.getRouter(KnightBlack.class.getSimpleName()).getClass().getSimpleName(), is("KnightRouter"));
    }
    /**
     * Trying to get a Pawn router
     */
    @Test
    public void whenAskForPawnRouterThenKnightRouterInstance() {
        assertThat(FACTORY.getRouter(PawnBlack.class.getSimpleName()).getClass().getSimpleName(), is("PawnRouter"));
    }
    /**
     * Trying to get a Queen router
     */
    @Test
    public void whenAskForQueenRouterThenQueenRouterInstance() {
        assertThat(FACTORY.getRouter(QeenBlack.class.getSimpleName()).getClass().getSimpleName(), is("QueenRouter"));
    }
    /**
     * Trying to get a Rook router
     */
    @Test
    public void whenAskForRookRouterThenRookRouterInstance() {
        assertThat(FACTORY.getRouter(RookBlack.class.getSimpleName()).getClass().getSimpleName(), is("RookRouter"));
    }
}

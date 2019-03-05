package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;

/**
 * Router factory (eager load singleton)
 * produces figure routers
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class RouterFactory {
    private static final RouterFactory INSTANCE = new RouterFactory();
    private RouterFactory() {

    }
    public static RouterFactory getInstance() {
        return INSTANCE;
    }
    /**
     * Getting instance of a specific router.
     * @param figure Figure that asks for a router.
     * @return router.
     */
    public Router getRouter(Figure figure) {
        Router router = null;
        if (figure instanceof BishopBlack || figure instanceof BishopWhite) {
            router = BishopRouter.getInstance();
        } else if (figure instanceof PawnBlack || figure instanceof PawnWhite) {
            router = PawnRouter.getInstance();
        } else if (figure instanceof KnightBlack || figure instanceof KnightWhite) {
            router = KnightRouter.getInstance();
        } else if (figure instanceof RookBlack || figure instanceof RookWhite) {
            router = RookRouter.getInstance();
        } else if (figure instanceof QeenBlack || figure instanceof QeenWhite) {
            router = QueenRouter.getInstance();
        } else if (figure instanceof KingBlack || figure instanceof KingWhite) {
            router = KingRouter.getInstance();
        }
        return router;
    }
}

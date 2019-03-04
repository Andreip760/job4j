package ru.job4j.chess.firuges.routers;
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
     * @param figureClass Figure class simple name.
     * @return router.
     */
    public Router getRouter(String figureClass) {
        Router router;
        switch (cutFigureClass(figureClass)) {
            case "Bishop" : router = BishopRouter.getInstance(); break;
            case "Pawn" : router = PawnRouter.getInstance(); break;
            case "Knight" : router = KnightRouter.getInstance(); break;
            case "Rook" : router = RookRouter.getInstance(); break;
            case "Qeen" : router = QueenRouter.getInstance(); break;
            case "King" : router = KingRouter.getInstance(); break;
            default: router = null;
        }
        return router;
    }
    private String cutFigureClass(String input) {
        String res = input.contains("Black") ? input.substring(0, input.indexOf("Black")) : input.substring(0, input.indexOf("White"));
        return res;
    }
}

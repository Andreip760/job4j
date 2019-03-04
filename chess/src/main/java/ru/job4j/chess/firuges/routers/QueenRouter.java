package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for queen (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class QueenRouter implements Router {
    private static QueenRouter instance;
    private QueenRouter() {
    }
    static QueenRouter getInstance() {
        if (instance == null) {
            instance = new QueenRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a queen movement.
     * Queen are able to move like a bishop or a rook. (we use their routers here).
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Movement route (if the movement is correct).
     */
    @Override
    public Cell[] getRoute(Cell source, Cell destination) {
        Cell[] result = {};
        int deltaX = Router.getDeltaX(source, destination);
        int deltaY = Router.getDeltaY(source, destination);
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = BishopRouter.getInstance().getRoute(source, destination);
        }
        if (Math.abs(deltaX) == 0 || Math.abs(deltaY) == 0) {
            result = RookRouter.getInstance().getRoute(source, destination);
        }
        return result;
    }
}

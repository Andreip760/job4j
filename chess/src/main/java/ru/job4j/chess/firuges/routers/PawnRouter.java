package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for pawn (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class PawnRouter implements Router {
    private static PawnRouter instance;
    private PawnRouter() {
    }
    static PawnRouter getInstance() {
        if (instance == null) {
            instance = new PawnRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a pawn.
     * Pawn moves straight and also it can move diagonally while it attacks.
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Movement route (if the movement is correct).
     */
    @Override
    public Cell[] getRoute(Cell source, Cell destination) {
        Cell[] result = {};
        int deltaX = Router.getDeltaX(source, destination);
        int deltaY = Router.getDeltaY(source, destination);
        if ((deltaY == -1 || deltaY == 1) && (deltaX >= -1 || deltaX <= 1)) {
            result = new Cell[] {destination};
        }
        return result;
    }
}

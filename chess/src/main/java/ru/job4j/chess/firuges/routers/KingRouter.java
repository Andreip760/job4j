package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for king (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class KingRouter implements Router {
    private static KingRouter instance;
    private KingRouter() {
    }
    static KingRouter getInstance() {
        if (instance == null) {
            instance = new KingRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a king.
     * King moves at one cell in any direction.
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Movement route (if the movement is correct).
     */
    @Override
    public Cell[] getRoute(Cell source, Cell destination) {
        Cell[] result = {};
        int deltaX = Router.getDeltaX(source, destination);
        int deltaY = Router.getDeltaY(source, destination);
        if (Math.abs(deltaX) <= 1 && Math.abs(deltaY) <= 1) {
            result = new Cell[] {destination};
        }
        return result;
    }
}

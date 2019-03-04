package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for bishop (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class BishopRouter implements Router {
    private static BishopRouter instance;
    private BishopRouter() {
    }
    static BishopRouter getInstance() {
        if (instance == null) {
            instance = new BishopRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a bishop
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
            result = new Cell[Math.abs(deltaX)];
            for (int i = 0; i < result.length; i++) {
                result[i] = Cell.findBy(
                        source.x + ((deltaX < 0 ? -1 : 1) * (i + 1)),
                        source.y + ((deltaY < 0 ? -1 : 1) * (i + 1))
                );
            }
        }
        return result;
    }
}

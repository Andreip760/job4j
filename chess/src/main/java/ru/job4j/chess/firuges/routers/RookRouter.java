package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for rook (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class RookRouter implements Router {
    private static RookRouter instance;
    private RookRouter() {
    }
    static RookRouter getInstance() {
        if (instance == null) {
            instance = new RookRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a rook movement
     * @param source Source cell
     * @param destination Destination cell
     * @return Movement route (if the movement is correct)
     */
    @Override
    public Cell[] getRoute(Cell source, Cell destination) {
        int deltaX = Router.getDeltaX(source, destination);
        int deltaY = Router.getDeltaY(source, destination);
        Cell[] result = {};
        if (deltaX == 0 || deltaY == 0) {
            int resultIndex = 0;
            result = new Cell[Math.abs(deltaX) + Math.abs(deltaY)];
            if (deltaX != 0) {
                for (int i = 0; i < Math.abs(deltaX); i++) {
                    result[resultIndex++] = Cell.findBy(source.x + (deltaX < 0 ? -1 : 1) * (i + 1), source.y);
                }
            } else {
                for (int i = 0; i < Math.abs(deltaY); i++) {
                    result[resultIndex++] = Cell.findBy(source.x, source.y + (deltaY < 0 ? -1 : 1) * (i + 1));
                }
            }
        }
        return result;
    }

}

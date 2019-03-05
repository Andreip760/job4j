package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Common router interface
 */
public interface Router {
    Cell[] getRoute(Cell source, Cell destination);
    /**
     * Method for get X movement's delta (to avoid mistakes).
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Delta X
     */
    default int getDeltaX(Cell source, Cell destination) {
        return destination.x - source.x;
    }
    /**
     * Method for get Y movement's delta (to avoid mistakes).
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Delta Y
     */
    default int getDeltaY(Cell source, Cell destination) {
        return destination.y - source.y;
    }
}

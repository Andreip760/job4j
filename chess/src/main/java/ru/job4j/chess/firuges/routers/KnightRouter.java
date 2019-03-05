package ru.job4j.chess.firuges.routers;

import ru.job4j.chess.firuges.Cell;
/**
 * Movement router for knight (lazy load singleton)
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class KnightRouter implements Router {
    private static KnightRouter instance;
    private KnightRouter() {
    }
    static KnightRouter getInstance() {
        if (instance == null) {
            instance = new KnightRouter();
        }
        return instance;
    }
    /**
     * Calculating the route of a knight
     * @param source Source cell.
     * @param destination Destination cell.
     * @return Movement route (if the movement is correct).
     */
    @Override
    public Cell[] getRoute(Cell source, Cell destination) {
        Cell[] result = {};
        int deltaX = this.getDeltaX(source, destination);
        int deltaY = this.getDeltaY(source, destination);
        if ((Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2)
                || (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1)
        ) {
            result = new Cell[Math.abs(deltaX) + Math.abs(deltaY)];
            int resIndex = 0;
            int coordX = source.x;
            for (int i = 0; i < Math.abs(deltaX); i++) {
                coordX += deltaX < 0 ? -1 : 1;
                result[resIndex++] = Cell.findBy(coordX, source.y);
            }
            for (int i = 0; i < Math.abs(deltaY); i++) {
                result[resIndex++] = Cell.findBy(coordX, source.y + (deltaY < 0 ? -1 : 1) * (i + 1));
            }
        }
        return result;
    }



}

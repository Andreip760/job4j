package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Checking the movement is correct and building route
     * @param source Source cell
     * @param dest Destination cell
     * @return Route or empty Cell's array
     */
    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] result = {};
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = new Cell[Math.abs(deltaX)];
            for (int i = 0; i < result.length; i++) {
                int index = (source.x * 8 + source.y) + ((deltaX < 0 ? -8 : 8) + (deltaY < 0 ? -1 : 1)) * (i + 1);
                result[i] = Cell.values()[index];
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

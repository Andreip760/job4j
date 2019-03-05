package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.routers.RouterFactory;

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
        return RouterFactory.getInstance().getRouter(this).getRoute(source, dest);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

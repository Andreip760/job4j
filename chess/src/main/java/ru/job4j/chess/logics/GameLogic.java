package ru.job4j.chess.logics;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Game logic interface.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 05.03.2019
 */
public interface GameLogic {
    boolean movePossible(final Cell[] route, final Figure[] figures, final Figure moving);
    /**
     * Checking that the route cell is occupied.
     * @param cell Cell.
     * @return True if the cell occupied.
     */
    default boolean cellOccupied(Cell cell, Figure[] figures) {
        boolean result = false;
        for (Figure figure : figures) {
            if (figure != null && figure.position().equals(cell)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

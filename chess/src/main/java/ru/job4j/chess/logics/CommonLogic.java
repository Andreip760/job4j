package ru.job4j.chess.logics;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
/**
 * Common logic
 * @author Andrei Pashchenko.
 * @version 1
 * @since 05.03.2019
 */
class CommonLogic implements GameLogic {
    /**
     * Checking for moving possibility for figures with common logic
     * @return Moving possibility.
     */
    @Override
    public boolean movePossible(final Cell[] route, final Figure[] figures, final Figure moving) {
        boolean result = true;
        for (int i = 0; i < route.length; i++) {
            if (this.cellOccupied(route[i], figures)) {
                result = false;
                break;
            }
        }
        return result;
    }

}

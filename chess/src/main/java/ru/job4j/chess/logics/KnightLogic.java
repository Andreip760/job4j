package ru.job4j.chess.logics;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
/**
 * Knight logic
 * @author Andrei Pashchenko.
 * @version 1
 * @since 05.03.2019
 */
class KnightLogic implements GameLogic {
    /**
     * Moving possibility for "Knight" (special logic)
     * can jump over figures
     * @return Moving possibility
     */
    @Override
    public boolean movePossible(final Cell[] route, final Figure[] figures, final Figure moving) {
        return !this.cellOccupied(route[route.length - 1], figures);
    }
}

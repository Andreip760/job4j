package ru.job4j.chess.logics;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
/**
 * King logic
 * @author Andrei Pashchenko.
 * @version 1
 * @since 05.03.2019
 */
class KingLogic implements GameLogic {
    /**
     * Moving possibility for "King" (special logic)
     * depends on check threat.
     * @return Moving possibility
     */
    @Override
    public boolean movePossible(final Cell[] route, final Figure[] figures, final Figure moving) {
        return !this.cellOccupied(route[0], figures);
    }
}

package ru.job4j.chess.logics;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
/**
 * Pawn logic
 * @author Andrei Pashchenko.
 * @version 1
 * @since 05.03.2019
 */
class PawnBlackLogic implements GameLogic {
    /**
     * Moving possibility for "Pawn" (special logic)
     * depends on color and enemies on diagonals
     * @return Moving possibility
     */
    @Override
    public boolean movePossible(final Cell[] route, final Figure[] figures, final Figure moving) {
        boolean result = false;
        if (route[0].y < moving.position().y) {
            result = route[0].x == moving.position().x && !this.cellOccupied(route[0], figures);
        }
        return result;
    }
}

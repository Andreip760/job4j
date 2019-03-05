package ru.job4j.chess;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;
/**
 * Class for checking that the moving figures obey the game rules.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class GameLogic {
    private final Cell[] route;
    private final Figure[] figures;
    private final Figure moving;
    /**
     * Constructor
     * @param route Figure's route.
     * @param figures All figures on the board.
     * @param moving Moving figure.
     */
    public GameLogic(final Cell[] route, final Figure[] figures, final Figure moving) {
        this.route = route;
        this.figures = figures;
        this.moving = moving;
    }
    /**
     * Main "move possible" method.
     * Selects common or special logic.
     * @return Moving possibility.
     */
    public boolean movePossible() {
        boolean result;
        if (this.moving instanceof KingBlack || this.moving instanceof KingWhite) {
            result = this.movePossibleKing();
        } else if (this.moving instanceof KnightBlack || this.moving instanceof KnightWhite) {
            result = this.movePossibleKnight();
        } else if (this.moving instanceof PawnBlack || this.moving instanceof PawnWhite) {
            result = this.movePossiblePawn();
        } else {
            result = this.movePossibleCommon();
        }
        return result;
    }
    /**
     * Checking for moving possibility for figures with common logic
     * @return Moving possibility.
     */
    private boolean movePossibleCommon() {
        boolean result = true;
        for (int i = 0; i < this.route.length; i++) {
            if (cellOccupied(this.route[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**
     * Moving possibility for "King" (special logic)
     * depends on check threat
     * @return Moving possibility
     */
    private boolean movePossibleKing() {
        return !this.cellOccupied(this.route[0]);
    }
    /**
     * Moving possibility for "Knight" (special logic)
     * can jump over figures
     * @return Moving possibility
     */
    private boolean movePossibleKnight() {
        return !this.cellOccupied(this.route[this.route.length - 1]);
    }
    /**
     * Moving possibility for "Pawn" (special logic)
     * depends on color and enemies on diagonals
     * @return Moving possibility
     */
    private boolean movePossiblePawn() {
        boolean result = false;
        if (
                (this.moving instanceof PawnBlack && this.route[0].y < this.moving.position().y)
                        || (this.moving instanceof PawnWhite && this.route[0].y > this.moving.position().y)
        ) {
            result = this.route[0].x == this.moving.position().x && !this.cellOccupied(this.route[0]);
        }
        return result;
    }
    /**
     * Checking that the route cell is occupied.
     * @param cell Cell.
     * @return True if the cell occupied.
     */
    private boolean cellOccupied(Cell cell) {
        boolean result = false;
        for (Figure figure : this.figures) {
            if (figure != null && figure.position().equals(cell)) {
                result = true;
                break;
            }
        }
        return result;
    }
}

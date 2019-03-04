package ru.job4j.chess;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
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
     * @param movingIndex Moving figure index.
     */
    public GameLogic(Cell[] route, Figure[] figures, int movingIndex) {
        this.route = route;
        this.figures = figures;
        this.moving = figures[movingIndex];
    }
    /**
     * Main "move possible" method.
     * @return Moving possibility.
     */
    public boolean movePossible() {
        boolean result;
        String figureClass = this.moving.getClass().getSimpleName();
        if (figureClass.contains("Knight") || figureClass.contains("Pawn") || figureClass.contains("King")) {
            result = this.movePossibleSpecial(figureClass);
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
     * Checking for moving possibility for figures with special logic
     * @param figureClass Figure Class name
     * @return Moving possibility
     */
    private boolean movePossibleSpecial(String figureClass) {
        boolean result;
        switch (cutFigureClass(figureClass)) {
            case "Knight" : result = this.movePossibleKnight(); break;
            case "Pawn" : result = this.movePossiblePawn(figureClass); break;
            case "King" : result = this.movePossibleKing(); break;
            default: result = false;
        }
        return result;
    }
    /**
     * Moving possibility for "King" (special logic)
     * depends on check threat
     * @return Moving possibility
     */
    private boolean movePossibleKing() {
        return !cellOccupied(this.route[0]);
    }
    /**
     * Moving possibility for "Knight" (special logic)
     * can jump over figures
     * @return Moving possibility
     */
    private boolean movePossibleKnight() {
        return !cellOccupied(this.route[this.route.length - 1]);
    }
    /**
     * Moving possibility for "Pawn" (special logic)
     * depends on color and enemies on diagonals
     * @return Moving possibility
     */
    private boolean movePossiblePawn(String figureClass) {
        boolean result = false;
        if (
                (figureClass.contains("Black") && this.route[0].y < this.moving.position().y)
                        || (figureClass.contains("White") && this.route[0].y > this.moving.position().y)
        ) {
            result = this.route[0].x == this.moving.position().x && !cellOccupied(this.route[0]);
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
    /**
     * Cutting off color from figure class string.
     * @param input Input string.
     * @return Figure class without color.
     */
    private String cutFigureClass(String input) {
        return input.contains("Black") ? input.substring(0, input.indexOf("Black")) : input.substring(0, input.indexOf("White"));
    }
}

package ru.job4j.chess.logics;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.*;
import ru.job4j.chess.firuges.white.*;
/**
 * Game logic factory (eager load singleton)
 * produces implementations of the game logic
 * @author Andrei Pashchenko.
 * @version 1
 * @since 03.03.2019
 */
public class GameLogicFactory {
    private static final GameLogicFactory INSTANCE = new GameLogicFactory();
    private GameLogicFactory() {

    }
    public static GameLogicFactory getInstance() {
        return INSTANCE;
    }
    /**
     * Defining and select needed strategy for implement "GameLogic" interface.
     * @param moving Moving figure
     * @return Game logic implementation object.
     */
    public GameLogic getGameLogic(Figure moving) {
        GameLogic result;
        if (moving instanceof KingBlack || moving instanceof KingWhite) {
            result = new KingLogic();
        } else if (moving instanceof KnightBlack || moving instanceof KnightWhite) {
            result = new KnightLogic();
        } else if (moving instanceof PawnBlack) {
            result = new PawnBlackLogic();
        } else if (moving instanceof PawnWhite) {
            result = new PawnWhiteLogic();
        } else {
            result = new CommonLogic();
        }
        return result;
    }
}

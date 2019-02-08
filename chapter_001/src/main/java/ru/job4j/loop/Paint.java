package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * Class for paint smth.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class Paint {
    /**
     * Assembly a string representation of a pyramid (right half).
     * @param height Pyramid height.
     * @return A right half.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Assembly a string representation of a pyramid (left half).
     * @param height Pyramid height.
     * @return A left half.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Assembly a string representation of a pyramid.
     * @param height Pyramid height.
     * @return Pyramid.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }
    /**
     * Generator loop.
     * @param height Pyramid height.
     * @param weight Pyramid width.
     * @param predict Predicate.
     * @return Pyramid.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}

package ru.job4j.array;
/**
 * Class for raising an array to a power
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class Square {
    /**
     * Creating an array (from 1 to bound) raised to the 2nd power.
     * @param bound Bound (last inclusive)
     * @return Array
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = (int) Math.pow(i, 2D);
        }
        return result;
    }
}

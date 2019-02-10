package ru.job4j.array;
/**
 * Class for generating 2-dimensional array
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.02.2019
 */
public class Matrix {
    /**
     * Generating an array representing the multiplication table
     * @param size Table size
     * @return Table
     */
    public int[][] multiple(int size) {
        int[][] result = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                result[row][col] = (row + 1) * (col + 1);
            }
        }
        return result;
    }
}

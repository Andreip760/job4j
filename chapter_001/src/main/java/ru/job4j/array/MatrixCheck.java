package ru.job4j.array;
/**
 * Class for checking the matrix for mono filling (diagonal).
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.02.2019
 */
public class MatrixCheck {
    /**
     * Checking the matrix is mono filled.
     * @param data Input matrix.
     * @return True if the diagonals are mono filled
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1][i - 1] != data[i][i] || data[i - 1][data.length - i] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

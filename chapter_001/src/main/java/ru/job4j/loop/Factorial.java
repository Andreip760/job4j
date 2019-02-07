package ru.job4j.loop;

/**
 * n-Factorial calculator.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class Factorial {
    /**
     * Calculation of n-Factorial
     * @param n End value (inclusive)
     * @return n-Factorial
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

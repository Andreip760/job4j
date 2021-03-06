package ru.job4j.max;
/**
 * Class for find maximum.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.02.2019
 */
public class Max {
    /**
     * Find maximum between first and second values.
     * @param first First value.
     * @param second Second value.
     * @return Maximum value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Find maximum between three values.
     * @param first First value.
     * @param second Second value.
     * @param third Third value
     * @return Maximum value.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}

package ru.job4j.calculator;

/**
 * Class for calculate ideal weight
 * @author Andrei Pashchenko
 * @version 1
 * @since 07.02.2019
 */
public class Fit {
    /**
     * Ideal man weight
     * @param height Height
     * @return Ideal man weight
     */
    double manWeight(double height) {
        return (height - 100D) * 1.15D;
    }
    /**
     * Ideal woman weight
     * @param height Height
     * @return Ideal woman weight
     */
    double womanWeight(double height) {
        return (height - 110D) * 1.15D;
    }
}

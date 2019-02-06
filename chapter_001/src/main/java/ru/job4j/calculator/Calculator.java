package ru.job4j.calculator;

/**
 * Class for simple calculations
 * @author Andrei Pashchenko
 * @version 1
 * @since 06.02.2019
 */
public class Calculator {
    private double result;
    /**
     * Method add
     * @param first First value
     * @param second Second value
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method sub
     * @param first First value
     * @param second Second value
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div
     * @param first First value
     * @param second Second value
     */
    public void div(double first, double second) {
        result = first / second;
    }
    /**
     * Method mult
     * @param first First value
     * @param second Second value
     */
    public void mult(double first, double second) {
        result = first * second;
    }
    /**
     * Method getResult
     * @return result of calculations
     */
    public double getResult() {
        return this.result;
    }
}
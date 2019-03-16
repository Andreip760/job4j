package ru.job4j.functional;

import java.util.function.BiFunction;
import java.util.function.Consumer;
/**
 * Class using functional interfaces and lambda expressions.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 15.03.2019
 */
public class Calculator {
    /**
     * Multi-purpose loop.
     * using functional interfaces.
     * @param start start index.
     * @param end end index.
     * @param value value.
     * @param operation Bi-function interface.
     * @param media Consumer interface.
     */
    public void multiple(
            int start,
            int end,
            int value,
            BiFunction<Integer, Integer, Double> operation,
            Consumer<Double> media
    ) {
        for (int index = start; index < end; index++) {
            media.accept(operation.apply(value, index));
        }
    }
    /**
     * Entry point.
     * Multiplication table of 2 (from 1 to 9).
     * using lambdas.
     * @param args Arguments.
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.multiple(
                1, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("BiFunction job: Multiply %s * %s = %s%n", index, value, result);
                    return result;
                },
                result -> System.out.printf("Consumer job: %s%n", result)
        );
    }
}

package ru.job4j.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
/**
 * Multi-purpose math class.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 17.03.2019
 */
public class MathLoop {
    /**
     * Multi-purpose math class (Function in range)
     * @param start range start.
     * @param end range end.
     * @param func Function.
     * @return Results.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int x = start; x < end; x++) {
            result.add(func.apply((double) x));
        }
        return result;
    }
}

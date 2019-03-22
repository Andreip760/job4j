package ru.job4j.matrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Class for matrix conversion.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 22.03.2019
 */
public class MatrixConverter {
    /**
     * Converting a 2-dim. array matrix into the list
     * @param matrix Input matrix.
     * @return Converted list.
     */
    public List<Integer> convertMatrix(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}

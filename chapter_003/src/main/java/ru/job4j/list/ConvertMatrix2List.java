package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * Class for conversion a two-dimensional array into the list
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.03.2019
 */
public class ConvertMatrix2List {
    /**
     * Converting the two-dimensional array into the list.
     * @param array Source array.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int col : row) {
                list.add(col);
            }
        }
        return list;
    }
}

package ru.job4j.convert;

import java.util.List;
/**
 * Class for conversion a list to a two-dimensional array
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.03.2019
 */
public class ConvertList2Array {
    /**
     * Converting the list to the two-dimensional array.
     * Considering that the default values of int arrays is 0.
     * @param list Source list.
     * @param rows Number of rows in the target array.
     * @return two-dimensional array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int row = 0;
        int col = 0;
        for (Integer val : list) {
            if (col == cells) {
                row++;
                col = 0;
            }
            array[row][col++] = val;
        }
        return array;
    }
}

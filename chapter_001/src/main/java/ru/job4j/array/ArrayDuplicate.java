package ru.job4j.array;
import java.util.Arrays;
/**
 * Class for cleaning the array from duplicates
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.02.2019
 */
public class ArrayDuplicate {
    /**
     * Cleaning the array from duplicates
     * @param array Input array
     * @return Array without duplicates
     */
    public String[] remove(String[] array) {
        int cutoff = array.length;
        for (int out = 0; out < cutoff; out++) {
            for (int in = out + 1; in < cutoff; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[cutoff - 1];
                    cutoff--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, cutoff);
    }
}

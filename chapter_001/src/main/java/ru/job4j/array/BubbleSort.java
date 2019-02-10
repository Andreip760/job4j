package ru.job4j.array;

/**
 * Class for sorting arrays
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.02.2019
 */
public class BubbleSort {
    /**
     * Sorting the array by "Bubble Sort"
     * @param array Input array
     * @return Sorted array
     */
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int k = 1; k < array.length - i; k++) {
                if (array[k - 1] > array[k]) {
                    array[k - 1] ^= array[k];
                    array[k] ^= array[k - 1];
                    array[k - 1] ^= array[k];
                }
            }
        }
        return array;
    }
}

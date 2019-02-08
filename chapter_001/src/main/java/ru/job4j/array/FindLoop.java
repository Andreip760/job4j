package ru.job4j.array;

/**
 * Simple array search.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class FindLoop {
    /**
     * Walk through array until the value'll be found.
     * @param data Input array.
     * @param el Value we search for.
     * @return Index of the value or -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}

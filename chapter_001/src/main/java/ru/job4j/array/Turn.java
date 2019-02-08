package ru.job4j.array;
/**
 * Class for reversing an array.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class Turn {
    /**
     * Reversing an array.
     * @param array Input array.
     * @return Reversed array.
     */
    public int[] back(int[] array) {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return array;
    }
}

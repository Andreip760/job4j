package ru.job4j.array;
/**
 * Class for checking array (mono fill).
 * @author Andrei Pashchenko.
 * @version 1
 * @since 08.02.2019
 */
public class Check {
    /**
     * Checking an array (mono fill)
     * @param data Input array
     * @return True if mono-filled
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }

}

package ru.job4j.array;

/**
 * Class for checking that given string starts with the prefix.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 09.02.2019
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Checking for the word starts with the prefix.
     * @param prefix Prefix.
     * @return True if the word starts with the prefix
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length <= this.data.length) {
            for (int i = 0; i < value.length; i++) {
                if (data[i] != value[i]) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}

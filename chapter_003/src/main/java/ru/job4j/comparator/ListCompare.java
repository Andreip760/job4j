package ru.job4j.comparator;

import java.util.Comparator;
/**
 * Class for comparator.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 11.03.2019
 */
public class ListCompare implements Comparator<String> {
    /**
     * Comparing two strings (char by char).
     * @param o1 Input string 1.
     * @param o2 Input string 2.
     * @return Comparison results.
     */
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        int minLength = o1.length() < o2.length() ? o1.length() : o2.length();
        for (int i = 0; i < minLength; i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                result = o1.charAt(i) < o2.charAt(i) ? -1 : 1;
                break;
            }
        }
        return result == 0 && o1.length() < o2.length() ? -1 : result;
    }
}

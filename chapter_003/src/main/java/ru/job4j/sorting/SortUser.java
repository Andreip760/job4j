package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 * Class for sorting users.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.03.2019
 */
public class SortUser {
    /**
     * Sort list of users/
     * @param users Input list
     * @return Sorted tree-set.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}

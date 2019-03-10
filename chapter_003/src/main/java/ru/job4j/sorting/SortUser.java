package ru.job4j.sorting;

import java.util.*;

/**
 * Class for sorting users.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.03.2019
 */
public class SortUser {
    /**
     * Sort list of users (by name length).
     * @param users Input list.
     * @return Sorted tree-set.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
                       @Override
                       public int compare(User o1, User o2) {
                           return Integer.compare(o1.getName().length(), o2.getName().length());
                       }
                   }
        );
        return users;
    }
    /**
     * Sort list of users (by all fields).
     * @param users Input list.
     * @return Sorted tree-set.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
                       @Override
                       public int compare(User o1, User o2) {
                           Integer name = o1.getName().compareTo(o2.getName());
                           return name != 0 ? name : o1.getAge().compareTo(o2.getAge());
                       }
                   }
        );
        return users;
    }
    /**
     * Sort list of users.
     * @param users Input list.
     * @return Sorted tree-set.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}

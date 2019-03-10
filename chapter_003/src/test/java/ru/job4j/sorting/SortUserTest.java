package ru.job4j.sorting;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.03.2019
 */
public class SortUserTest {
    private SortUser sortUser = new SortUser();
    private List<User> users;
    @Before
    public void resetUsers() {
        this.users = new ArrayList<>();
    }
    /**
     * Unsorted users
     */
    @Test
    public void whenUnsortedInThenSortedTreeSet() {
        this.users.add(new User("Маша", 20));
        this.users.add(new User("Андрей", 37));
        this.users.add(new User("Вася", 18));
        Set<User> result = this.sortUser.sort(this.users);
        assertThat(result, contains(this.users.get(2), this.users.get(0), this.users.get(1)));
    }
    /**
     * Sorted users
     */
    @Test
    public void whenSortedInThenSortedTreeSet() {
        this.users.add(new User("Вася", 18));
        this.users.add(new User("Маша", 20));
        this.users.add(new User("Андрей", 37));
        Set<User> result = this.sortUser.sort(this.users);
        assertThat(result, contains(this.users.get(0), this.users.get(1), this.users.get(2)));
    }
    /**
     * Sort bt all fields.
     */
    @Test
    public void whenUnsortedByAllThenSortedList() {
        User first = new User("Маша", 20);
        User second = new User("Маша", 18);
        User third = new User("Андрей", 19);
        User fourth = new User("Андрей", 38);
        this.users.addAll(Arrays.asList(first, second, third, fourth));
        List<User> result = this.sortUser.sortByAllFields(this.users);
        assertThat(result, contains(third, fourth, second, first));
    }
    /**
     * Sort bt name length.
     */
    @Test
    public void whenUnsortedByNameLengthThenSortedList() {
        User first = new User("Маша", 20);
        User second = new User("Настя", 18);
        User third = new User("Андрей", 19);
        User fourth = new User("Оля", 38);
        this.users.addAll(Arrays.asList(first, second, third, fourth));
        List<User> result = this.sortUser.sortNameLength(this.users);
        assertThat(result, contains(fourth, first, second, third));
    }
}

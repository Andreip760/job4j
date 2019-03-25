package ru.job4j.sorting;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;

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
    private final User first = new User("Маша", 20);
    private final User second = new User("Андрей", 37);
    private final User third = new User("Вася", 18);
    private final User fourth = new User("Настя", 18);
    private final User fifth = new User("Оля", 38);

    @Before
    public void resetUsers() {
        this.users = new ArrayList<>();
    }
    /**
     * Unsorted users
     */
    @Test
    public void whenUnsortedInThenSortedTreeSet() {
        this.users = List.of(this.first, this.second, this.third);
        Set<User> result = this.sortUser.sort(this.users);
        Set<User> expect = Set.of(this.third, this.first, this.second);
        assertThat(result, is(expect));
    }
    /**
     * Sorted users
     */
    @Test
    public void whenSortedInThenSortedTreeSet() {
        this.users = List.of(this.third, this.first, this.second);
        Set<User> result = this.sortUser.sort(this.users);
        Set<User> expect = Set.of(this.first, this.second, this.third);
        assertThat(result, is(expect));
    }
    /**
     * Sort bt all fields.
     */
    @Test
    public void whenUnsortedByAllThenSortedList() {
        User addFirst = new User("Маша", 18);
        User addSecond = new User("Андрей", 19);
        this.users.addAll(Arrays.asList(this.first, addFirst, this.second, addSecond));
        List<User> result = this.sortUser.sortByAllFields(this.users);
        List<User> expect = List.of(addSecond, this.second, addFirst, this.first);
        assertThat(result, is(expect));
    }
    /**
     * Sort bt name length.
     */
    @Test
    public void whenUnsortedByNameLengthThenSortedList() {
        this.users.addAll(Arrays.asList(this.first, this.fourth, this.second, this.fifth));
        List<User> result = this.sortUser.sortNameLength(this.users);
        List<User> expect = List.of(this.fifth, this.first, this.fourth, this.second);
        assertThat(result, is(expect));
    }
}

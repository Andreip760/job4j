package ru.job4j.sorting;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import java.util.ArrayList;
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
}

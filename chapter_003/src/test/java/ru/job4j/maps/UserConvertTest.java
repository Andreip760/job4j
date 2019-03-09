package ru.job4j.maps;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 09.03.2019
 */
public class UserConvertTest {
    /**
     * Converting two users into a hash map.
     */
    @Test
    public void when3UsersThenMapOfUsers() {
        UserConvert converter = new UserConvert();
        List<User> users = new ArrayList<>();
        User first = new User(1, "Вася", "Москва");
        User second = new User(2, "Маша", "Ялта");
        users.add(first);
        users.add(second);
        HashMap<Integer, User> result = converter.process(users);
        assertThat(result, hasEntry(1, first));
        assertThat(result, hasEntry(2, second));
    }
}

package ru.job4j.maps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User first = new User(1, "Вася", "Москва");
        User second = new User(2, "Маша", "Ялта");
        List<User> users = List.of(first, second);
        HashMap<Integer, User> result = converter.process(users);
        Map<Integer, User> expect = Map.of(1, first, 2, second);
        assertThat(result, is(expect));
    }
}

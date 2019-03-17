package ru.job4j.functional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import ru.job4j.functional.UserConvert.User;
import java.util.Arrays;
import java.util.List;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 16.03.2019
 */
public class UserConvertTest {
    private final List<String> names = Arrays.asList("Ivan", "Anna", "Petr");
    /**
     * Converting 3 names to 3 users.
     */
    @Test
    public void when3NamesThen3Users() {
        UserConvert converter = new UserConvert();
        List<User> result = converter.convert(names, User::new);
        assertThat(result.size(), is(3));
        assertThat(result.get(1).toString(), is("User{name='Anna'}"));
    }
}

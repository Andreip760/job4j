package ru.job4j.addresses;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
/**
 * Test.
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class ProfilesTest {
    /**
     * Getting addresses. Having 2 user profiles.
     */
    @Test
    public void whenTwoProfilesThenTwoAddresses() {
        Address first = new Address("City1", "Street1", "1A", "123");
        Address second = new Address("City2", "Street2", "2A", "456");
        List<Profile> input = Arrays.asList(new Profile(first), new Profile(second));
        assertThat(new Profiles().collect(input), is(Arrays.asList(first, second)));
    }
}

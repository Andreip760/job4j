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
    private Address first = new Address("City1", "Street1", 1, 123);
    private Address second = new Address("City3", "Street3", 3, 789);
    private Address third = new Address("City2", "Street2", 2, 456);
    private Address fourth = new Address("City1", "Street1", 1, 123);

    /**
     * Getting addresses. Having 2 unique user profiles.
     */
    @Test
    public void whenTwoProfilesThenTwoAddresses() {
        List<Profile> input = Arrays.asList(new Profile(this.first), new Profile(this.second));
        assertThat(new Profiles().collect(input), is(Arrays.asList(this.first, this.second)));
    }
    /**
     * Getting unique and sorted addresses. Having 4 user profiles with duplicates.
     */
    @Test
    public void whenFourProfilesDistinctThenThreeSortedAddresses() {
        List<Profile> input = Arrays.asList(
                new Profile(this.first),
                new Profile(this.second),
                new Profile(this.third),
                new Profile(this.fourth)
        );
        assertThat(new Profiles().collect(input), is(Arrays.asList(this.first, this.third, this.second)));
    }
}

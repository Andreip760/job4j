package ru.job4j.addresses;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Class for working with user profiles.
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class Profiles {
    /**
     * Getting addresses from user profiles.
     * @param profiles List of user profiles.
     * @return List of addresses.
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }
}

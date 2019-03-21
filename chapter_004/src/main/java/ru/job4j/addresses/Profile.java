package ru.job4j.addresses;
/**
 * Class for user profile.
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }
    /**
     * Getting address from the user profile.
     * @return Address.
     */
    public Address getAddress() {
        return this.address;
    }
}

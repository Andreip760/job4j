package ru.job4j.addresses;
/**
 * Address class for user profile.
 * @author Andrei Pashchenko
 * @version 1
 * @since 21.03.2019
 */
public class Address {
    private String city;
    private String street;
    private int building;
    private int apartment;

    public Address(String city, String street, int building, int apartment) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }
}

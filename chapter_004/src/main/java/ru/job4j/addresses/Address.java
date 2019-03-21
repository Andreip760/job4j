package ru.job4j.addresses;

import java.util.Objects;
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
    /**
     * Getting city.
     * @return City.
     */
    public String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return this.building == address.building
                && this.apartment == address.apartment
                && this.city.equals(address.city)
                && this.street.equals(address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.street, this.building, this.apartment);
    }
}

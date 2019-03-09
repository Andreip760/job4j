package ru.job4j.maps;
/**
 * Class user.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 09.03.2019
 */
public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    /**
     * Get user id
     * @return Id
     */
    public int getId() {
        return this.id;
    }
    /**
     * Get user name
     * @return Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Get user city
     * @return City
     */
    public String getCity() {
        return this.city;
    }
}

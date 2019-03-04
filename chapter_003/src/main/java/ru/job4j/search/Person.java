package ru.job4j.search;

/**
 * Class person for phone book.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 04.03.2019
 */
public class Person {
    private String name;
    private String surname;
    private String phone;
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }
    /**
     * Getting person name
     * @return Name
     */
    public String getName() {
        return name;
    }
    /**
     * Getting person surname
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Getting person phone
     * @return Phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * Getting person address
     * @return Address
     */
    public String getAddress() {
        return address;
    }
}
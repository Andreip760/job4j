package ru.job4j.sorting;
/**
 * Class user.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 10.03.2019
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    /**
     * Get user name.
     * @return Name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Get user age.
     * @return Age.
     */
    public Integer getAge() {
        return this.age;
    }
    /**
     * Users comparator.
     * @param o Input user
     * @return Comparing result.
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
    }
}

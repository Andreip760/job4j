package ru.job4j.bank;

import java.util.Objects;
/**
 * Class for bank user.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 13.03.2019
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Getting name.
     * @return Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getting passport.
     * @return Passport.
     */
    public String getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getName().equals(user.getName()) && getPassport().equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getPassport());
    }
}

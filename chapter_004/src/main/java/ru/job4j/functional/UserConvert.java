package ru.job4j.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/**
 * Class for converting list of names to List of users
 * using lambda expressions.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 16.03.2019
 */
public class UserConvert {
    /**
     * Class user.
     */
    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='"
                    + name
                    + '\''
                    + '}';
        }
    }
    /**
     * Converter loop.
     * @param names List of names
     * @param function Conversion function
     * @return List of users
     */
    public List<User> convert(List<String> names, Function<String, User> function) {
        List<User> users = new ArrayList<>();
        names.forEach(
                name -> users.add(function.apply(name))
        );
        return users;
    }
    /**
     * Entry point
     * @param args Arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        UserConvert users = new UserConvert();
        List<User> data = users.convert(names, User::new);
        data.forEach(System.out::println);

    }
}

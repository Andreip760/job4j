package ru.job4j.pseudo;

import java.util.StringJoiner;
/**
 *Drawing strategy "Triangle"
 *@author Andrei Pashchenko
 *@version 1
 *@since 19.02.2019
 */
public class Triangle implements Shape {
    /**
     * String representation of a triangle.
     * @return Triangle.
     */
    @Override
    public String draw() {
        StringJoiner pict = new StringJoiner(System.lineSeparator())
                .add("*   ")
                .add("**  ")
                .add("*** ")
                .add("****");
        return pict.toString();
    }
}

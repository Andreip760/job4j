package ru.job4j.pseudo;

import java.util.StringJoiner;
/**
 *Drawing strategy "Square".
 *@author Andrei Pashchenko.
 *@version 1
 *@since 19.02.2019
 */
public class Square implements Shape {
    /**
     * String representation of a square.
     * @return Square.
     */
    @Override
    public String draw() {
        StringJoiner pict = new StringJoiner(System.lineSeparator())
                .add("****")
                .add("*  *")
                .add("*  *")
                .add("****");
        return pict.toString();
    }
}

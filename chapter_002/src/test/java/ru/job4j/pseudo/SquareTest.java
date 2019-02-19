package ru.job4j.pseudo;

import java.util.StringJoiner;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 19.02.2019
 */
public class SquareTest {
    /**
     * Drawing a square
     */
    @Test
    public void whenDrawSquare() {
        assertThat(
                new Square().draw(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("****")
                                .add("*  *")
                                .add("*  *")
                                .add("****")
                                .toString()
                )
        );
    }
}

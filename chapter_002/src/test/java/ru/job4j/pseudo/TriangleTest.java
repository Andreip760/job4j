package ru.job4j.pseudo;

import java.util.StringJoiner;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 19.02.2019
 */
public class TriangleTest {
    /**
     * Drawing a triangle
     */
    @Test
    public void whenDrawTriangle() {
        assertThat(
                new Triangle().draw(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("*   ")
                                .add("**  ")
                                .add("*** ")
                                .add("****")
                                .toString()
                )
        );
    }
}
